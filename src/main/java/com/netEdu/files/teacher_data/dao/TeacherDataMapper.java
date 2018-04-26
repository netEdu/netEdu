package com.netEdu.files.teacher_data.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Course;
import com.netEdu.entity.StudentData;
import com.netEdu.entity.TeacherData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherDataMapper extends BaseMapper<TeacherData> {

    @Select("select * from course where teacher_id = teacher_id and del_flag = 0 and audit_status = 1")
    List<Course> queryEnableCourse(String teacher_id);

    @Select("<script>select * " +
            "from teacher_data " +
            "left join course on teacher_data.course_id = course.course_id " +
            "left join teacher on teacher_data.teacher_id = teacher.teacher_id " +
            "where 1=1" +
            "<if test=\"course_name !=null and course_name != '' \">and course_name like CONCAT(CONCAT('%',#{course_name},'%')) </if> " +
            "<if test=\"data_title !=null and data_title != '' \">and data_title like CONCAT(CONCAT('%',#{data_title},'%')) </if> " +
            "<if test=\"data_type !=null and data_type != '' \">and data_type = #{data_type} </if> " +
            "<if test=\"course_id !=null and course_id != '' \">and teacher_data.course_id = #{course_id} </if> " +
            "and teacher_data.teacher_id = #{teacher_id}" +
            "</script>")
    List<TeacherData> showTeacherDataList(TeacherData teacherData);

    @Select("<script>SELECT " +
            "student_data.*, student.`name`," +
            "course.course_name," +
            "student.class_num " +
            "FROM " +
            "student_data " +
            "LEFT JOIN course ON student_data.course_id = course.course_id\n" +
            "LEFT JOIN student ON student_data.student_id = student.student_id " +
            "where 1=1" +
            "<if test=\"course_name !=null and course_name != '' \">and course_name like CONCAT(CONCAT('%',#{course_name},'%')) </if> " +
            "<if test=\"data_title !=null and data_title != '' \">and data_title like CONCAT(CONCAT('%',#{data_title},'%')) </if> " +
            "<if test=\"name !=null and name != '' \">and name like CONCAT(CONCAT('%',#{name},'%')) </if> " +
            "<if test=\"course_id !=null and course_id != '' \">and student_data.course_id = #{course_id} </if> " +
            "<if test=\"data_type !=null and data_type != '' \">and data_type = #{data_type} </if> " +
            "<if test=\"class_num !=null and class_num != '' \">and class_num = #{class_num} </if> " +
            "</script>")
    List<StudentData> showStudentDataList(StudentData studentData);

    @Select("select savepath from teacher_data where data_id = #{0}")
    String selectSavepath(String data_id);

    @Delete("delete from teacher_data where FIND_IN_SET(data_id,#{0})")
    void removeFiles(String data_ids);

}
