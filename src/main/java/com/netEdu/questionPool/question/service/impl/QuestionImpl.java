package com.netEdu.questionPool.question.service.impl;

import com.netEdu.entity.Question;
import com.netEdu.entity.QuestionOption;
import com.netEdu.questionPool.question.dao.QuestionMapper;
import com.netEdu.questionPool.question.service.QuestionService;
import com.netEdu.questionPool.question.vo.QuestionPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void add(Question question){
        questionMapper.insertSelective(question);
        String[] options = question.getOptions().split(",");
        for (int i = 0;i < options.length;i ++){
            questionMapper.insertIntoOptions(question.getQuestion_id(),options[i].toString());
        }
        int option_id = questionMapper.selectAnswerForQuestion(question.getQuestion_id(),question.getQuestion_answer());
        questionMapper.selectIdToAnswer(question.getQuestion_id(),option_id);
    }

    @Override
    public void del(String ids){
        questionMapper.deleteQuestions(ids);
    }

    @Override
    public void update(Question question){
        if (question.getQuestion_content() != null){
            questionMapper.updateOptions(question.getOption_id(),question.getOption_content());
        }
        questionMapper.updateByPrimaryKeySelective(question);
    }

    @Override
    public Question findOne(int id) {
        return questionMapper.queryOne(id);
    }

    @Override
    public List<QuestionOption> queryOptions(int id) {
        return questionMapper.findOptions(id);
    }

    @Override
    public List<Question> findAllByCriteria(QuestionPage questionPage) {
        Integer rowCount = questionMapper.queryByCount(questionPage);
        questionPage.getPager().setRowCount(rowCount);
        questionPage.setPage(questionPage.getPager().getStartIndex() - 1);
        return questionMapper.queryAll(questionPage);
    }

    @Override
    public List<Question> selectNotExistQuestion(List existQuestionIdList) {
        return questionMapper.selectNotExistQuestion(existQuestionIdList);
    }

}
