package com.netEdu.freeDiscuss.group.dao;

import com.netEdu.entity.Group;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Insert({"INSERT INTO group(group_name,person_id) VALUES(#{group_name},#{person_id})"})
    @Options(useGeneratedKeys = true, keyProperty = "group.group_id")
    void insertGroup(Group group);


    @Delete("delete from group where group_id = #{group_id}")
    @Options(useGeneratedKeys = true, keyProperty = "group.group_id")
     void deleteGroup(Group group);

    @Select("select person_id from group where group_id = #{group_id}")
    @Results({
            @Result(property = "person_id",  column = "person_id"),

    })
    List<Group> getMember(Group group);


    @Update("UPDATE group SET person_id=#{person_id},WHERE group_id =#{group_id}")
    void updateMember(Group group);

    @Select("select group_id,group_name,person_id from group where group_id=#{group_id}")
    @Results({
            @Result(property = "group_id", column = "group_id"),
            @Result(property = "group_name", column = "group_name"),
            @Result(property = "person_id", column = "person_id")
    })
    List<Group> selectByGroupId(Group group);


    @Select("select group_id,group_name,person_id from group where person_id like concat('%' , ',' , #{person_id} , ',' , '%')")
    @Results({
            @Result(property = "group_id", column = "group_id"),
            @Result(property = "group_name", column = "group_name"),
            @Result(property = "person_id", column = "person_id")
    })
    List<Group> selectByPersonId(Group group);


}
