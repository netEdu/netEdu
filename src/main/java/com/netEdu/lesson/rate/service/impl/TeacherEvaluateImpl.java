package com.netEdu.lesson.rate.service.impl;

import com.netEdu.entity.TeacherEvaluate;
import com.netEdu.lesson.rate.dao.QuestionnaireDao;
import com.netEdu.lesson.rate.dao.TeacherEvaluateDao;
import com.netEdu.lesson.rate.page.TeacherEvaluatePage;
import com.netEdu.lesson.rate.service.TeacherEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private QuestionnaireDao questionnaireDao;
    @Override
    public void addTeacherEvaluate(TeacherEvaluate teacherEvaluate){
        teacherEvaluateDao.addTeacherEvaluate(teacherEvaluate);

    }

    @Override
    public List<TeacherEvaluate> queryByPage(TeacherEvaluatePage page) {
        Integer rowCount = teacherEvaluateDao.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        List<TeacherEvaluate> teacherEvaluates =new ArrayList<>();
        teacherEvaluates=teacherEvaluateDao.queryByPage(page);
        for (TeacherEvaluate t:teacherEvaluates) {
            t.getQuestionnaire().setSurveyQuestionList(questionnaireDao.selectByQuestionnaireId(t.getQuestionnaire().getSurvey_questions()));
        }

        return  teacherEvaluates;
        //return teacherEvaluateDao.queryByPage(page);
    }

    @Override
    public void upTeacherEvaluate(TeacherEvaluate teacherEvaluate) {
        teacherEvaluateDao.upTeacherEvaluate(teacherEvaluate);
    }

    @Override
    public void deleteTeacherEvaluate(String ids) {
        teacherEvaluateDao.deleteTeacherEvaluate(ids);
    }

}
