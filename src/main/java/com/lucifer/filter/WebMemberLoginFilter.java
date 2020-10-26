package com.lucifer.filter;

import com.lucifer.model.Member;
import com.lucifer.service.MemberLoginService;
import com.lucifer.utils.Constant;
import com.lucifer.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/carpool/*"})
public class WebMemberLoginFilter implements Filter {

    @Resource
    MemberLoginService memberLoginService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("WebMemberLoginFilter.doFilter has been called");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String spath = request.getServletPath();
        //System.out.println("request.getContextPath()"+req.getContextPath());
        log.info("spath: {}",spath);
        String[] urls = {".js",".css",".ico",".jpg",".jpeg",".png"};
        for (String str : urls) {
            if (spath.endsWith(str)) {
                log.info("WebMemberLoginFilter.doFilter skipped by {}",str);
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        log.info("WebMemberLoginFilter.doFilter executing next");
        String token = RequestUtils.getCookie(Constant.MEMBER_ACCESS_TOKEN,request);
        log.info("token is : {}",token);
        Member member = null;
        if (!StringUtils.isEmpty(token)) {
            member = memberLoginService.getMemberByToken(token);
        }
        servletRequest.setAttribute(Constant.MEMBER_LOGIN,member);
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
