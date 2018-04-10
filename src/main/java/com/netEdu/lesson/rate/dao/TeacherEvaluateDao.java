package com.netEdu.lesson.rate.dao;

import com.netEdu.entity.TeacherEvaluate;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-03
 * Time: 15:01
 */
@Mapper
public interface TeacherEvaluateDao {
    void addTeacherEvaluate(TeacherEvaluate teacherEvaluate);
}
