package com.netEdu.lesson.apply.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    @Select("select * from course where course_name = #{0} and del_flag = 0")
    List<Course> queryCourse(String CourseName);

    @Update("update course set del_flag = 1 where FIND_IN_SET(course_id,#{0})")
    void deleteCourse(String ids);

    @Select("<script>select * from course where 1=1 " +
            "<if test=\"course_name !=null and course_name != '' \">and course_name like CONCAT(CONCAT('%',#{course_name},'%')) </if> " +
            "<if test=\"course_introduce !=null and course_introduce != '' \">and course_introduce like CONCAT(CONCAT('%',#{course_introduce},'%')) </if> " +
            "<if test=\"class_num !=null and class_num != '' \">and class_num = #{class_num} </if> " +
            "<if test=\"audit_status !=null and audit_status != '' \">and audit_status = #{audit_status} </if> " +
            "and del_flag = 0 and teacher_id = #{teacher_id} "+
            "</script>")
    List<Course> queryCourseList(Course course);

    void updateCourse(Course course);
}
