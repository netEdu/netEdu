package com.netEdu.client.teacher.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Course;
import com.netEdu.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.validation.constraints.Max;
import java.util.List;

@Mapper
public interface TeacherClientMapper extends BaseMapper<Teacher>{

    @Select("select * from teacher where teacher_id = #{0}")
    Teacher selectById(int teacher_id);

    @Select("select * from course " +
            "left join teacher on course.teacher_id = teacher.teacher_id " +
            "where teacher.teacher_id = #{0} and course.audit_status = 1 and course.del_flag = 0")
    List<Course> selectCourseById(int teacher_id);

}
