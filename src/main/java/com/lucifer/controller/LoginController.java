package com.lucifer.controller;

import com.lucifer.mapper.oauth2.MemberMapper;
import com.lucifer.service.MemberLoginService;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/oauth2")
public class LoginController {

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

    @RequestMapping(value = "/sign-up",method = RequestMethod.GET)
    public String signUp(){
        //String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
        //request.setAttribute("totalMemberCount",totalMemberCount);
        return   "/oauth2/sign-up";
    }

    @RequestMapping(value = "/sign-up/send-code",method = RequestMethod.POST)
    @ResponseBody
    public Result sendSingUpCode(String email) throws Exception {
        return memberLoginService.sendSingUpCode(email);
    }

    @RequestMapping(value = "/email-reset",method = RequestMethod.GET)
    public String reset(){
        //String totalMemberCount = memberMapper.getSysConfigValue("total_member_count");
        //request.setAttribute("totalMemberCount",totalMemberCount);
        return   "/oauth2/email-reset";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result submitLogin(@RequestParam String telephone, @RequestParam String password, HttpServletResponse response ){
        Result result = memberLoginService.loginByTelephonePhone(telephone,password,response);
        return result;
    }


}
