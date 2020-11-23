package com.lucifer.mapper;

import com.lucifer.annotation.MapperScanSelf;
import com.lucifer.model.Answer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@MapperScanSelf
public interface InfoMapper {

    @Select("select info from test where id = #{id}")
   String getInfo(@Param(value = "id") Integer id);
}
