package com.lucifer.utils;

import com.lucifer.model.Member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static String getCookie(String name, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(null ==cookies){
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static Boolean isMemberLogin( HttpServletRequest request){
        Member member = getMemberLogin(request);
        if(null != member){
            return true;
        }
        return false;
    }

    public static Member getMemberLogin( HttpServletRequest request){
        Member member = (Member) request.getAttribute(Constant.MEMBER_LOGIN);
        return member;
    }
}
