package com.netEdu.client.student.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Course;
import com.netEdu.entity.Group;
import com.netEdu.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentClientMapper extends BaseMapper<Student>{

    @Select("select * from student where student_id = #{0}")
    Student selectById(int student_id);

    /**
     * 查自己上的课
     * @param student_id
     * @return
     */
    @Select("select * from course " +
            "left join student on course.class_num = student.class_num " +
            "where course.del_flag = 0 and course.audit_status = 1 and student.student_id = #{0}")
    List<Course> selectCourseById(int student_id);

}
