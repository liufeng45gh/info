package com.lucifer.controller;

import com.lucifer.model.Carpool;
import com.lucifer.model.Member;
import com.lucifer.service.CarpoolService;
import com.lucifer.utils.RequestUtils;
import com.lucifer.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
    public Result publishSubmit(@RequestBody Carpool carpool, HttpServletRequest request){
        return  carpoolService.saveCarpool(carpool,request);
    }

    @RequestMapping(value = {"/my"},method = RequestMethod.GET)
    public String allPublish(HttpServletRequest request){
        carpoolService.myList(request);
        return  "/carpool/my";
    }

    @RequestMapping(value = {"/{id}"},method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteOne(@PathVariable(name = "id") Long id, HttpServletRequest request){
        Member member = RequestUtils.getMemberLogin(request);
        carpoolService.deleteMyCarpool(id,member.getId());
        return  Result.ok();
    }

    @RequestMapping(value = {"/modify/{id}"},method = RequestMethod.GET)
    public String modify(@PathVariable Long id,HttpServletRequest request){
        carpoolService.showModifyCarpool(id,request);
        return  "/carpool/modify";
    }

    @RequestMapping(value = {"/modify"},method = RequestMethod.POST)
    @ResponseBody
    public Result modifySubmit(@RequestBody Carpool carpool, HttpServletRequest request){
        return  carpoolService.modifyCarpool(carpool,request);
    }

}
