package com.netEdu.questionPool.question.service;

import com.netEdu.entity.Option;
import com.netEdu.entity.Question;

import java.util.List;

public interface QuestionService {

    void add(Question question);

    void addOption(Option option);

    void del(String ids);

    void update(Question question);

    Question findOne(int id);

    List<Question> findAllByCriteria(Question question);

}
