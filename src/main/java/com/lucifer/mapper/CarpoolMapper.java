package com.lucifer.mapper;

import com.lucifer.annotation.MapperScanSelf;
import com.lucifer.model.Carpool;
import com.lucifer.model.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MapperScanSelf
public interface CarpoolMapper {

    List<Question> questionCmsSearchList(@Param("offset") Integer offset,@Param("count") Integer count,@Param(value = "title") String title);

    Integer questionCmsSearchCount(@Param(value = "title") String title);

    Integer insertCarpool(Carpool carpool);

    List<Carpool> listByMemberId(@Param(value = "memberId") Long memberId);

    List<Carpool> topList(@Param(value = "limit") Integer limit);

    Carpool getMyCarpool(@Param(value = "id") Long id,@Param(value = "memberId") Long memberId);

    Integer deleteMyCarpool(@Param(value = "id") Long id,@Param(value = "memberId") Long memberId);

    Integer updateCarpool(Carpool carpool);

    Integer updateQuestionStatus(@Param(value = "id") Long id, @Param(value = "status") Integer status);

    List<Long> enableIdList();

    List<Long> enableRandomIdList( @Param(value = "count")  Integer count);
}
