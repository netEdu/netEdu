package com.netEdu.lesson.rate.service.impl;

import com.netEdu.entity.TeacherEvaluate;
import com.netEdu.lesson.rate.dao.TeacherEvaluateDao;
import com.netEdu.lesson.rate.page.TeacherEvaluatePage;
import com.netEdu.lesson.rate.service.TeacherEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-03
 * Time: 15:04
 */
@Service
public class TeacherEvaluateImpl implements TeacherEvaluateService{
    @Autowired
    private TeacherEvaluateDao teacherEvaluateDao;
    @Override
    public void addTeacherEvaluate(TeacherEvaluate teacherEvaluate){
        teacherEvaluateDao.addTeacherEvaluate(teacherEvaluate);

    }

    @Override
    public List<TeacherEvaluate> queryByPage(TeacherEvaluatePage page) {
        return teacherEvaluateDao.queryByPage(page);
    }

}
