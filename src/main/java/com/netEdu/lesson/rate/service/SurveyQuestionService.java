package com.netEdu.lesson.rate.service;

import com.netEdu.entity.SurveyQuestion;
import com.netEdu.lesson.rate.page.SurveyQuestionPage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-17
 * Time: 9:46
 */
public interface SurveyQuestionService {
    void addSurveyQuestion(SurveyQuestion surveyQuestion);

    void delSurveyQuestion(String question_ids);

    List<SurveyQuestion> selectBypage(SurveyQuestionPage page);


    void upSurveyQuestion(SurveyQuestion surveyQuestion);

    SurveyQuestion selectByQuestionid(int question_id);
}
