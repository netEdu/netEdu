package com.netEdu.files.student_data.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.StudentData;
import com.netEdu.entity.TeacherData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentDataMapper extends BaseMapper<StudentData> {

    @Select("<script>select *" +
            "from student_data " +
            "left join course on student_data.course_id = course.course_id " +
            "where 1=1" +
            "<if test=\"course_name !=null and course_name != '' \">and course_name like CONCAT(CONCAT('%',#{course_name},'%')) </if> " +
            "<if test=\"data_title !=null and data_title != '' \">and data_title like CONCAT(CONCAT('%',#{data_title},'%')) </if> " +
            "<if test=\"data_type !=null and data_type != '' \">and data_type = #{data_type} </if> " +
            "<if test=\"course_id !=null and course_id != '' \">and course_id = #{course_id} </if> " +
            "and student_id = #{student_id}" +
            "</script>")
    List<StudentData> showStudentDataList(StudentData studentData);

    @Select("<script>select *" +
            "from teacher_data " +
            "left join course on teacher_data.course_id = course.course_id " +
            "left join teacher on course.teacher_id = teacher.teacher_id " +
            "where 1=1" +
            "<if test=\"course_name !=null and course_name != '' \">and course_name like CONCAT(CONCAT('%',#{course_name},'%')) </if> " +
            "<if test=\"data_title !=null and data_title != '' \">and data_title like CONCAT(CONCAT('%',#{data_title},'%')) </if> " +
            "<if test=\"name !=null and name != '' \">and name like CONCAT(CONCAT('%',#{name},'%')) </if> " +
            "<if test=\"data_type !=null and data_type != '' \">and data_type = #{data_type} </if> " +
            "<if test=\"course_id !=null and course_id != '' \">and course_id = #{course_id} </if> " +
            "and teacher_data.share = 0" +
            "</script>"
    )
    List<TeacherData> showTeacherDataList(TeacherData teacherData);

    @Select("select savepath from student_data where data_id = #{0}")
    String selectSavepath(String data_id);

    @Delete("delete from student_data where FIND_IN_SET(data_id,#{0})")
    void removeFiles(String data_ids);

}
