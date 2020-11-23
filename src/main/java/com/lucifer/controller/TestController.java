package com.lucifer.controller;

import com.lucifer.mapper.InfoMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    InfoMapper infoMapper;

    @RequestMapping(value = {"/get-db-info"},method = RequestMethod.GET)
    @ResponseBody
    public String  getDbInfo(){
        return infoMapper.getInfo(1);
    }
}
