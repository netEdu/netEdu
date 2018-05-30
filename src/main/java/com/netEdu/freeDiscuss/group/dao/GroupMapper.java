package com.netEdu.freeDiscuss.group.dao;

import com.netEdu.entity.Group;
import com.netEdu.entity.Student;
import com.netEdu.entity.Teacher;
import com.netEdu.entity.VO.GroupVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Insert("insert into `group` (group_name,person_id,del_flag) values(#{group.group_name},#{group.person_id},0)")
    @Options(useGeneratedKeys = true, keyProperty = "group.group_id")
    void insertGroup(@Param("group") Group group);


    @Delete("delete from `group` where group_id = #{group.group_id}")
    @Options(useGeneratedKeys = true, keyProperty = "group.group_id")
     void deleteGroup(@Param("group") Group group);

    @Select("select person_id from `group` where group_id = #{group_id}")
    @Results({
            @Result(property = "person_id",  column = "person_id"),

    })
    List<Group> getMember(Group group);


    @Update("UPDATE `group` SET person_id=#{person_id},WHERE group_id =#{group_id}")
    void updateMember(Group group);

    @Select("select group_id,group_name,person_id from `group` where group_id=#{group_id}")
    @Results({
            @Result(property = "group_id", column = "group_id"),
            @Result(property = "group_name", column = "group_name"),
            @Result(property = "person_id", column = "person_id")
    })
    List<Group> selectByGroupId(Group group);


    @Select("select group_id,group_name,person_id from `group` where person_id like concat('%' , ',' , #{person_id} , ',' , '%')")
    @Results({
            @Result(property = "group_id", column = "group_id"),
            @Result(property = "group_name", column = "group_name"),
            @Result(property = "person_id", column = "person_id")
    })
    List<Group> selectByPersonId(Group group);


    @Select("select teacher_id,name from teacher where teacher_id = #{pid}")
    @Results({
            @Result(property = "teacher_id", column = "teacher_id"),
            @Result(property = "name", column = "name")
    })
    Teacher selectTeacherWithId(int pid);

    @Select("select student_id,name from student where student_id = #{pid}")
    @Results({
            @Result(property = "student_id", column = "student_id"),
            @Result(property = "name", column = "name")
    })
    Student selectStudentWithId(int pid);

    @Select("select * from student where class_num = #{0} and del_flag = 0")
    List<Student> selectStudentsByClass(String id);

}
