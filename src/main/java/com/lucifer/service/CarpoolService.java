package com.lucifer.service;

import com.lucifer.mapper.CarpoolMapper;
import com.lucifer.model.Carpool;
import com.lucifer.utils.Result;

import javax.annotation.Resource;
import java.util.Date;

public class CarpoolService {

    @Resource
    CarpoolMapper carpoolMapper;

    public Result saveCarpool(Carpool carpool){
        carpool.setCreatedAt(new Date());
        carpool.setUpdatedAt(new Date());
        carpoolMapper.insertCarpool(carpool);
        return Result.ok();
    }
}
