package com.netEdu.login.dao;

import com.netEdu.entity.Student;
import com.netEdu.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface LoginMapper {

    @Select("select class_num,student_id from student where username=#{username} and password=#{password}")
    @Results({
            @Result(property = "class_num",  column = "class_num"),
            @Result(property = "student_id",  column = "student_id")

    })
    List<Student> login(Student student);


    @Select("select teacher_id from teacher where username=#{username} and password=#{password}")
    @Results({
            @Result(property = "teacher_id",  column = "teacher_id"),

    })
    List<Teacher> loginTeacher(Teacher teacher);
}
