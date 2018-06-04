package com.netEdu.admin.verify.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseVerifyMapper extends BaseMapper<Course>{

    @Select("<script>" +
            "SELECT\n" +
            "\tcourse.*, teacher.`name`\n" +
            "FROM\n" +
            "\tcourse\n" +
            "LEFT JOIN teacher ON course.teacher_id = teacher.teacher_id " +
            "where 1=1 " +
            "<if test=\"course_name !=null and course_name != '' \">and course_name like CONCAT(CONCAT('%',#{course_name},'%')) </if> " +
            "<if test=\"name !=null and name != '' \">and name like CONCAT(CONCAT('%',#{name},'%')) </if> " +
            "<if test=\"class_num !=null and class_num != '' \">and class_num = #{class_num} </if> " +
            "<if test=\"audit_status !=null and audit_status != '' \">and FIND_IN_SET(audit_status,#{audit_status})</if> " +
            "and course.del_flag = 0" +
            "</script>")
    List<Course> selectCourseList(Course course);

}
