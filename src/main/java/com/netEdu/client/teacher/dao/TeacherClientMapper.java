package com.netEdu.client.teacher.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TeacherClientMapper extends BaseMapper<Teacher>{

    @Select("select * from teacher where teacher_id = #{0}")
    Teacher selectById(int teacher_id);

}
