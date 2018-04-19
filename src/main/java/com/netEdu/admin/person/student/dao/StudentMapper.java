package com.netEdu.admin.person.student.dao;

import com.netEdu.admin.person.student.vo.StudentPage;
import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student>{

    /**
     * 表中多少条数据
     * @param studentPage
     * @return
     */
    @Select("select count(1) from student")
    Integer queryByCount(StudentPage studentPage);

    @Select("<script>select * from student where 1=1 " +
            "<if test=\"name !=null and name != '' \">and name like CONCAT(CONCAT('%',#{name},'%')) </if> " +
            "<if test=\"sex !=null and sex != '' \">and sex = #{sex} </if> " +
            "<if test=\"class_num !=null and class_num != '' \">and class_num = #{class_num} </if> " +
            "and del_flag = 0 limit ${page-1},#{pageSize}" +
            "</script>")
    List<Student> selectStudent(StudentPage studentPagee);

}
