package com.lucifer.service;

import com.lucifer.constant.MailTemplate;
import com.lucifer.constant.ResultCode;
import com.lucifer.exception.UnexpectedException;
import com.lucifer.mapper.oauth2.MemberMapper;
import com.lucifer.mapper.oauth2.UserMapper;
import com.lucifer.model.Member;
import com.lucifer.model.user.User;
import com.lucifer.utils.Constant;
import com.lucifer.utils.Md5Utils;
import com.lucifer.utils.RandomUtil;
import com.lucifer.utils.Result;
import com.lucifer.vo.RegisterMemberVo;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

@Service
public class MemberLoginService {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserMapper userMapper;

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private EmailService emailService;

    @Resource
    StringRedisTemplate stringRedisTemplate ;

    @Resource
    MemberCacheService memberCacheService;

    public Result loginByTelephonePhone(String telephone, String password, HttpServletResponse response){

        User dbUser = userMapper.getUserByAccount("klny-question");
        if  (null == dbUser)  {
            return Result.fail("用户未找到");
        }
        String md5Password = Md5Utils.md5(Md5Utils.md5(password)+dbUser.getSalt());
        logger.info("md5Password: "+md5Password);
        if (!md5Password.equals(dbUser.getPassword())) {
            return Result.fail("密码错误");
        }

        Member member = memberMapper.getByPhone(telephone);
        if (null == member) {
            member = new Member();
            member.setPhone(telephone);
            memberMapper.insertMember(member);
            String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
            Integer tmp = Integer.valueOf(totalMemberCount);
            tmp = tmp + 1;
            totalMemberCount = String.valueOf(tmp);
            memberMapper.updateSysConfigValue("total_member_count",totalMemberCount);

        }
        String token = RandomStringUtils.randomAlphanumeric(20);

        memberMapper.insertMemberToken(member.getId(),token);

        Cookie cookie = new Cookie(Constant.TOKEN,token);
        cookie.setPath("/");
        cookie.setMaxAge(365 * 24*60*60);
        response.addCookie(cookie);

        return Result.ok(token);
    }

    public Member getMemberByToken(String token)  {
        String memberId = this.getMemberIdByToken(token);
        logger.info("memberId is : {}",memberId);
        if (memberId == null) {
            //throw new UnexpectedException(" memberId can not find by token: " + token);
            return null;
        }

        Member member = memberCacheService.getMemberById(memberId);
//        if (null == member) {
//            throw new UnexpectedException(" member can not find by id: " + memberId);
//        }
        return member;
    }

    public void updateMemberInfo(String token,Member member) throws UnexpectedException {
        String memberId = this.getMemberIdByToken(token);
        if (memberId == null) {
            throw new UnexpectedException(" memberId can not find by token: " + token);
        }
        member.setId(Long.valueOf(memberId));
        memberMapper.updateMemberInfo(member);
        memberCacheService.removeMemberByIdCache(String.valueOf(memberId));
    }

    public Result singUpSendCode(String email) throws Exception {
        Integer memberCount = memberMapper.getByCountByEmail(email);
        if (memberCount>0) {
            return Result.fail(ResultCode.USER_EXIST);
        }
        String code = RandomUtil.randomInt(6);
        String key = this.getRegisterCodeKey(email);
        logger.info("email: {}, code : {}",email,code);
        stringRedisTemplate.opsForValue().set(key,code,15, TimeUnit.MINUTES);
        emailService.sendMail(email, MailTemplate.registerCodeSubject,MailTemplate.generateRegisterCodeContent(code));

        return Result.ok();
    }

    public Result resetSendCode(String email) throws Exception {
        Integer memberCount = memberMapper.getByCountByEmail(email);
        if (memberCount==0) {
            return Result.fail(ResultCode.USER_NOT_EXIST);
        }
        String code = RandomUtil.randomInt(6);
        String key = this.getResetCodeKey(email);
        logger.info("email: {}, code : {}",email,code);
        stringRedisTemplate.opsForValue().set(key,code,15, TimeUnit.MINUTES);
        emailService.sendMail(email,MailTemplate.resetCodeSubject,MailTemplate.generateResetCodeContent(code));

        return Result.ok();
    }

    private String getRegisterCodeKey(String email){
        return "oauth2:register:"+email;
    }

    private String getResetCodeKey(String email){
        return "oauth2:reset:"+email;
    }

    public Result signUpSubmit(RegisterMemberVo memberVo, HttpServletResponse response){
        Integer memberCount = memberMapper.getByCountByEmail(memberVo.getEmail());
        if (memberCount>0) {
            return Result.fail(ResultCode.USER_EXIST);
        }

        String key = this.getRegisterCodeKey(memberVo.getEmail());
        String codeStore = stringRedisTemplate.opsForValue().get(key);
        if (!memberVo.getCode().equals(codeStore)) {
            return Result.fail(ResultCode.CODE_NOT_EQUALS);
        }
        String salt = RandomUtil.getNextSalt();
        String md5Password= Md5Utils.md5Password(memberVo.getPassword(),salt);
        memberVo.setSalt(salt);
        memberVo.setPassword(md5Password);
        memberMapper.insertMember(memberVo);
        logger.info("user id is {}",memberVo.getId());
        this.generateToken(memberVo.getId(),response);
        return Result.ok();
    }

    private void generateToken(Long userId,HttpServletResponse response){
        String token = RandomStringUtils.randomAlphanumeric(20);
        String key = this.getTokenKey(token);
        stringRedisTemplate.opsForValue().set(key,String.valueOf(userId),90,TimeUnit.DAYS);
        Cookie cookie = new Cookie(Constant.MEMBER_ACCESS_TOKEN,token);
        cookie.setPath("/");
        cookie.setMaxAge(90 * 24*60*60);
        response.addCookie(cookie);
    }

    private String getTokenKey(String token){
        return "oauth2:token:"+token;
    }

    public String getMemberIdByToken(String token){
        String key = this.getTokenKey(token);
        logger.info("key : {}",key);
        String id = stringRedisTemplate.opsForValue().get(key);
        logger.info("redis getMemberIdByToken: {}",id);
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        return id;
        //return Long.valueOf(id);
    }

    public Result emailResetSubmit(RegisterMemberVo memberVo){
        Integer memberCount = memberMapper.getByCountByEmail(memberVo.getEmail());
        if (memberCount==0) {
            return Result.fail(ResultCode.USER_NOT_EXIST);
        }

        String key = this.getResetCodeKey(memberVo.getEmail());
        String codeStore = stringRedisTemplate.opsForValue().get(key);
        if (!memberVo.getCode().equals(codeStore)) {
            return Result.fail(ResultCode.CODE_NOT_EQUALS);
        }
        String salt = RandomUtil.getNextSalt();
        String md5Password= Md5Utils.md5Password(memberVo.getPassword(),salt);
        //memberVo.setSalt(salt);
        //memberVo.setPassword(md5Password);
        memberMapper.updatePassword(memberVo.getEmail(),salt,md5Password);
        //this.generateToken(memberVo.getId(),response);
        return Result.ok();
    }

    public Result signInSubmit(RegisterMemberVo memberVo, HttpServletResponse response){
        Member dbMember = memberMapper.getLoginMemberByEmail(memberVo.getEmail());
        if (null == dbMember) {
            return Result.fail(ResultCode.USER_NOT_EXIST);
        }

        String md5Password= Md5Utils.md5Password(memberVo.getPassword(),dbMember.getSalt());
       if (!md5Password.equals(dbMember.getPassword())) {
           return Result.fail(ResultCode.EMAIL_OR_PASSWORD_WRONG);
       }
        this.generateToken(dbMember.getId(),response);
        return Result.ok();
    }

    public Result settingProfile(Member member){
        memberMapper.updateMemberInfo(member);
        return Result.ok();
    }

}
