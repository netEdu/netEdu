package com.netEdu.lesson.rate.dao;

import com.netEdu.entity.TeacherEvaluate;
import com.netEdu.lesson.rate.page.TeacherEvaluatePage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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

    List<TeacherEvaluate> queryByPage(TeacherEvaluatePage page);
}
