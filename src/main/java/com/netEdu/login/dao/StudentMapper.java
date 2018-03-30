package com.netEdu.login.dao;

import com.netEdu.login.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface StudentMapper {

    @Select("select class_num from student where name=#{name} and password=#{password}")
    @Results({
            @Result(property = "class_num",  column = "class_num"),

    })
    List<Student> login(Student student);

}
