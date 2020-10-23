package com.lucifer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/carpool")
public class CarPoolController {

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String toLogin(){
        return   "/carpool/index";
    }
}
