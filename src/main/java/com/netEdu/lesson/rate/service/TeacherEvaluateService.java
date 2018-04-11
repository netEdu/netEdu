package com.netEdu.lesson.rate.service;

import com.netEdu.entity.TeacherEvaluate;
import com.netEdu.lesson.rate.page.TeacherEvaluatePage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-03
 * Time: 15:02
 */
public interface TeacherEvaluateService {
    void addTeacherEvaluate(TeacherEvaluate teacherEvaluate);

    List<TeacherEvaluate> queryByPage(TeacherEvaluatePage page);

    void upTeacherEvaluate(TeacherEvaluate teacherEvaluate);
}
