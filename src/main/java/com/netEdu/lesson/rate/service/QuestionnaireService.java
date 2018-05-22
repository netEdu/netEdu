package com.netEdu.lesson.rate.service;

import com.netEdu.entity.Questionnaire;
import com.netEdu.entity.SurveyQuestion;
import com.netEdu.entity.VO.QuestionnaireVO;
import com.netEdu.lesson.rate.page.QuestionnairePage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-03
 * Time: 15:02
 */
public interface QuestionnaireService {

    void add(Questionnaire questionnaire);

    void upQuestionnaire(Questionnaire questionnaire);

    void deleteQuestionnaire(String ids);

    List<QuestionnaireVO> queryByPage(QuestionnairePage page);

    List<SurveyQuestion> selectByQuestionnaireId(int questionnaire_id);

    List<QuestionnaireVO> selectAll();

    Questionnaire selectInfo(int questionnaire_id);
}
