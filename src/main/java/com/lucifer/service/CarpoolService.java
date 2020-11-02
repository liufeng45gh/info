package com.lucifer.service;

import com.lucifer.mapper.CarpoolMapper;
import com.lucifer.model.Carpool;
import com.lucifer.model.Member;
import com.lucifer.utils.RequestUtils;
import com.lucifer.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class CarpoolService {

    @Resource
    CarpoolMapper carpoolMapper;

    public Result saveCarpool(Carpool carpool,HttpServletRequest request){
        Member member = RequestUtils.getMemberLogin(request);
        carpool.setCreatedAt(new Date());
        carpool.setUpdatedAt(new Date());
        carpool.setMemberId(member.getId());
        carpoolMapper.insertCarpool(carpool);
        return Result.ok();
    }

    public List<Carpool> myList(HttpServletRequest request){
        Member member = RequestUtils.getMemberLogin(request);
        List<Carpool> myList =  this.listByMemberId(member.getId());
        request.setAttribute("myList",myList);
        return myList;
    }

    public List<Carpool> listByMemberId(Long memberId){
        return carpoolMapper.listByMemberId(memberId);
    }

    public Integer deleteMyCarpool(Long id,Long memberId){
        return carpoolMapper.deleteMyCarpool(id,memberId);
    }

    public void showModifyCarpool(Long id,HttpServletRequest request){
        Member member = RequestUtils.getMemberLogin(request);
        Carpool entity = carpoolMapper.getMyCarpool(id,member.getId());
        request.setAttribute("entity",entity);
        String [] fromArray = entity.getFrom().split(",");
        request.setAttribute("fromArray",fromArray);
        String [] toArray = entity.getTo().split(",");
        request.setAttribute("toArray",toArray);

        List passBodyArray = new ArrayList();
        if (!StringUtils.isEmpty(entity.getPass1())) {
            String [] passArray = entity.getPass1().split(",");
            passBodyArray.add(passArray);
        }

        if (!StringUtils.isEmpty(entity.getPass2())) {
            String [] passArray = entity.getPass2().split(",");
            passBodyArray.add(passArray);
        }

        if (!StringUtils.isEmpty(entity.getPass3())) {
            String [] passArray = entity.getPass3().split(",");
            passBodyArray.add(passArray);
        }

        request.setAttribute("passBodyArray",passBodyArray);
        SimpleDateFormat dayFormat  = new SimpleDateFormat("yyyy-MM-dd");
        String day = dayFormat.format(entity.getDepartureTime());
        request.setAttribute("day",day);

        SimpleDateFormat hhFormat  = new SimpleDateFormat("HH");
        String hh = hhFormat.format(entity.getDepartureTime());
        request.setAttribute("hh",hh);

        SimpleDateFormat mmFormat  = new SimpleDateFormat("mm");
        String mm = mmFormat.format(entity.getDepartureTime());
        request.setAttribute("mm",mm);
    }

    public Result modifyCarpool(Carpool carpool,HttpServletRequest request){
        log.info("modifyCarpool has been called");
        Member member = RequestUtils.getMemberLogin(request);
        carpool.setMemberId(member.getId());
        carpool.setUpdatedAt(new Date());
        Integer updateCount = carpoolMapper.updateCarpool(carpool);
        log.info("updateCount {}",updateCount);
        log.info("carpool.departureTime : {}",carpool.getDepartureTime());
        return Result.ok();
    }
}
