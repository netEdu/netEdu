package com.netEdu.client.teacher.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Course;
import com.netEdu.entity.Paper;
import com.netEdu.entity.Student;
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

    @Select("SELECT\n" +
            "\tstudent.*,course.class_num\n" +
            "FROM\n" +
            "\tstudent\n" +
            "LEFT JOIN course ON student.class_num = course.class_num\n" +
            "LEFT JOIN teacher ON course.teacher_id = teacher.teacher_id\n" +
            "where teacher.teacher_id = #{0}\n" +
            "GROUP BY student.student_id\n" +
            "ORDER BY student.student_id")
    List<Student> selectMyStudent(int teacher_id);

    @Select("select paper.*," +
            "answer.student_answers " +
            "from paper " +
            "left join answer " +
            "on paper.paper_id = answer.paper_id " +
            "left join student " +
            "on answer.student_id = student.student_id " +
            "where student.student_id = #{0}")
    List<Paper> selectMyStudentPaper(int student_id);

}
