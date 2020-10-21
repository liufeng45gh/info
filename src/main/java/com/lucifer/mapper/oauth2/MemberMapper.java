package com.lucifer.mapper.oauth2;

import com.lucifer.annotation.MapperScanSelf;
import com.lucifer.model.Member;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface MemberMapper {

    Integer insertMemberToken(@Param("memberId")Long memberId,@Param("token")String token);

    Integer insertMember(Member member);

    Member getByPhone(@Param("telephone") String telephone);

    Member getLoginMemberByEmail(@Param("email") String email);

    Integer getByCountByEmail(@Param("email") String email);

    Long getMemberIdByToken(@Param("token")String token);

    Member getMemberById(@Param("id") Long id);

    void updateMemberInfo(Member member);

    Integer updatePassword(@Param("email") String email,@Param("salt") String salt,@Param("password") String password);

    String getSysConfigValue(@Param("key") String key);

    void updateSysConfigValue(@Param("key") String key, @Param("value")String value);
}
