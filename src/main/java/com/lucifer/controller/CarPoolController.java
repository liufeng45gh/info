package com.lucifer.controller;

import com.lucifer.model.Carpool;
import com.lucifer.service.CarpoolService;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/carpool")
public class CarPoolController {

    @Resource
    CarpoolService carpoolService;

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String toLogin(){
        return   "/carpool/index";
    }
    @RequestMapping(value = {"/publish"},method = RequestMethod.GET)
    public String publish(){
        return  "/carpool/publish";
    }

    @RequestMapping(value = {"/publish"},method = RequestMethod.POST)
    @ResponseBody
    public Result publishSubmit(@RequestBody Carpool carpool){
        return  carpoolService.saveCarpool(carpool);
    }

    @RequestMapping(value = {"/publish/all"},method = RequestMethod.GET)
    public String allPublish(){
        return  "/carpool/publish-all";
    }

}
