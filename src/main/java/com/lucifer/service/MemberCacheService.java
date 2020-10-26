package com.lucifer.service;

import com.lucifer.constant.SpringCache;
import com.lucifer.mapper.oauth2.MemberMapper;
import com.lucifer.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Slf4j
public class MemberCacheService {

    @Resource
    private MemberMapper memberMapper;

    @Cacheable(cacheNames = SpringCache.carpool.MemberById +"MemberCacheService.getMemberById",key = "#id", unless="#result == null" )
    public Member getMemberById(Long id){
        Member member =  memberMapper.getMemberById(id);
        if (null!=member) {
            member.setPassword(null);
        }
        return member;
    }


    @CacheEvict(cacheNames = SpringCache.carpool.MemberById +"MemberCacheService.getMemberById",key = "#id" )
    public void removeMemberByIdCache(String id) {
        //do nothing
        log.info("removeMemberByIdCache {}",id);
    }
}
