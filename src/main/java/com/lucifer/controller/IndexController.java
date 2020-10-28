package com.lucifer.controller;

import com.lucifer.mapper.CarpoolMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    CarpoolMapper questionMapper;



    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String toLogin(){
        return   "redirect:/carpool/index/";
    }


}
