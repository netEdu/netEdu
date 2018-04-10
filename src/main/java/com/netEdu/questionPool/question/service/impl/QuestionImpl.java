package com.netEdu.questionPool.question.service.impl;

import com.netEdu.entity.Question;
import com.netEdu.questionPool.question.dao.QuestionMapper;
import com.netEdu.questionPool.question.service.QuestionService;
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
    }

    @Override
    public void del(Question question){

    }

    @Override
    public void update(Question question){
        questionMapper.updateByPrimaryKeySelective(question);
    }

    @Override
    public List<Question> query(Question question) {
        return null;
    }
}
