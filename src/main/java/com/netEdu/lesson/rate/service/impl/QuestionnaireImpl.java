package com.netEdu.lesson.rate.service.impl;

import com.netEdu.entity.Questionnaire;
import com.netEdu.lesson.rate.dao.QuestionnaireDao;
import com.netEdu.lesson.rate.page.QuestionnairePage;
import com.netEdu.lesson.rate.service.QuestionnaireService;
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
public class QuestionnaireImpl implements QuestionnaireService{
    @Autowired
    private QuestionnaireDao questionnaireDao;


    @Override
    public void add(Questionnaire questionnaire) {
        questionnaireDao.insertSelective(questionnaire);

    }

    @Override
    public void upQuestionnaire(Questionnaire questionnaire) {
        questionnaireDao.updateByPrimaryKeySelective(questionnaire);
    }

    @Override
    public void deleteQuestionnaire(String ids) {
        questionnaireDao.deleteQuestionnaire(ids);
    }

    @Override
    public List<Questionnaire> queryByPage(QuestionnairePage page) {
        Integer rowCount = questionnaireDao.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        return questionnaireDao.queryByPage(page);

    }

    //查询单个调查问卷
    @Override
    public Questionnaire selectByQuestionnaireId(int questionnaire_id) {
        return questionnaireDao.selectByQuestionnaireId(questionnaire_id);
    }
}
