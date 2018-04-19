package com.netEdu.admin.person.teacher.dao;

import com.netEdu.admin.person.teacher.vo.TeacherPage;
import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher>{

    /**
     * 表中多少条数据
     * @param teacherPage
     * @return
     */
    @Select("select count(1) from teacher")
    Integer queryByCount(TeacherPage teacherPage);

    @Select("<script>select * from teacher where 1=1 " +
            "<if test=\"name !=null and name != '' \">and name like CONCAT(CONCAT('%',#{name},'%')) </if> " +
            "<if test=\"sex !=null and sex != '' \">and sex = #{sex} </if> " +
            "<if test=\"position !=null and position != '' \">and position = #{position} </if> " +
            "and del_flag = 0 limit ${page-1},#{pageSize}" +
            "</script>")
    List<Teacher> selectTeacher(TeacherPage teacherPage);

}
