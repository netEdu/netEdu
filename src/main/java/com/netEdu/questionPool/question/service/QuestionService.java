package com.netEdu.questionPool.question.service;

import com.netEdu.entity.Question;
import com.netEdu.entity.QuestionOption;
import com.netEdu.questionPool.question.vo.QuestionPage;

import java.util.List;

public interface QuestionService {

    void add(Question question);

    void del(String ids);

    void update(Question question);

    Question findOne(int id);

    List<QuestionOption> queryOptions(int id);

    List<Question> findAllByCriteria(QuestionPage questionPage);


    List<Question> selectNotExistQuestion(List existQuestionIdList);
}
