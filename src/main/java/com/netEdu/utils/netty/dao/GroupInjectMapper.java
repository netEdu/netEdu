package com.netEdu.utils.netty.dao;

import com.netEdu.entity.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupInjectMapper {

    @Select("select group_id from `group` where person_id like concat('%' , ',' , #{id} , ',' , '%')")
    @Results({
            @Result(property = "group_id",  column = "group_id")
    })
    List<Group> getAllGroup(String id);

}
