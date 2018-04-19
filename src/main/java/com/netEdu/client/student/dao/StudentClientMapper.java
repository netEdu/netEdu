package com.netEdu.client.student.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentClientMapper extends BaseMapper<Student>{

    @Select("select * from student where student_id = #{0}")
    Student selectById(int student_id);

}
