package com.netEdu.lesson.rate.service.impl;

import com.netEdu.entity.SurveyQuestion;
import com.netEdu.lesson.rate.dao.SurveyQuestionDao;
import com.netEdu.lesson.rate.page.SurveyQuestionPage;
import com.netEdu.lesson.rate.service.SurveyQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-17
 * Time: 9:47
 */
@Service
public class SurveyQuestionImpl implements SurveyQuestionService{
    @Autowired
    private SurveyQuestionDao surveyQuestionDao;

    @Override
    public void addSurveyQuestion(SurveyQuestion surveyQuestion) {
        surveyQuestionDao.insertSelective(surveyQuestion);
    }

    @Override
    public void delSurveyQuestion(String question_ids) {
        surveyQuestionDao.delSurveyQuestion(question_ids);
    }

    @Override
    public List<SurveyQuestion> selectBypage(SurveyQuestionPage page) {
        Integer rowCount = surveyQuestionDao.selectByCount(page);
        page.getPager().setRowCount(rowCount);
        return surveyQuestionDao.selectByPage(page);
    }

    @Override
    public void upSurveyQuestion(SurveyQuestion surveyQuestion) {
        surveyQuestionDao.updateByPrimaryKey(surveyQuestion);
    }

    @Override
    public SurveyQuestion selectByQuestionid(int question_id) {
        return surveyQuestionDao.selectByQuestionid(question_id);
    }

}
