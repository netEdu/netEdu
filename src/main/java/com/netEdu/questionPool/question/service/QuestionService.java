package com.netEdu.questionPool.question.service;

import com.netEdu.entity.Question;

import java.util.List;

public interface QuestionService {

    void add(Question question);

    void del(Question question);

    void update(Question question);

    List<Question> query(Question question);
}
