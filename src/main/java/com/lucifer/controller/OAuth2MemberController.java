package com.lucifer.controller;

import com.lucifer.mapper.oauth2.MemberMapper;
import com.lucifer.model.Member;
import com.lucifer.service.MemberLoginService;
import com.lucifer.utils.Constant;
import com.lucifer.utils.Result;
import com.lucifer.vo.RegisterMemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/oauth2")
public class OAuth2MemberController {

    @Resource
    MemberLoginService memberLoginService;

    @Resource
    MemberMapper memberMapper;

    @RequestMapping(value = {"/","index"},method = RequestMethod.GET)
    public String index(HttpServletRequest request){
        request.setAttribute("independent",false);
        return  "/web/index";
    }

    @RequestMapping(value = "/sign-in",method = RequestMethod.GET)
    public String signIn(){
        //String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
        //request.setAttribute("totalMemberCount",totalMemberCount);
        return   "/oauth2/sign-in";
    }

    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpServletResponse response){
        //String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
        //request.setAttribute("totalMemberCount",totalMemberCount);
        Cookie cookie = new Cookie(Constant.MEMBER_ACCESS_TOKEN,"");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return   "redirect:/oauth2/sign-in";
    }

    @RequestMapping(value = "/sign-in",method = RequestMethod.POST)
    @ResponseBody
    public Result signInSubmit(@RequestBody RegisterMemberVo member,HttpServletResponse response){
        //String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
        //request.setAttribute("totalMemberCount",totalMemberCount);
        return memberLoginService.signInSubmit(member,response);
    }

    @RequestMapping(value = "/sign-up",method = RequestMethod.GET)
    public String signUp(){
        //String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
        //request.setAttribute("totalMemberCount",totalMemberCount);
        return   "/oauth2/sign-up";
    }

    @RequestMapping(value = "/sign-up/send-code",method = RequestMethod.POST)
    @ResponseBody
    public Result singUpSendCode(String email) throws Exception {
        return memberLoginService.singUpSendCode(email);
    }

    @RequestMapping(value = "/sign-up",method = RequestMethod.POST)
    @ResponseBody
    public Result signUpSubmit(@RequestBody RegisterMemberVo member,HttpServletResponse response) {
        return memberLoginService.signUpSubmit(member,response);
    }


    @RequestMapping(value = "/email-reset",method = RequestMethod.GET)
    public String reset(){
        //String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
        //request.setAttribute("totalMemberCount",totalMemberCount);
        return   "/oauth2/email-reset";
    }

    @RequestMapping(value = "/email-reset/send-code",method = RequestMethod.POST)
    @ResponseBody
    public Result resetSendCode(String email) throws Exception {
        return memberLoginService.resetSendCode(email);
    }

    @RequestMapping(value = "/email-reset",method = RequestMethod.POST)
    @ResponseBody
    public Result emailResetSubmit(@RequestBody RegisterMemberVo member)  {
        return memberLoginService.emailResetSubmit(member);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result submitLogin(@RequestParam String telephone, @RequestParam String password, HttpServletResponse response ){
        Result result = memberLoginService.loginByTelephonePhone(telephone,password,response);
        return result;
    }



}
