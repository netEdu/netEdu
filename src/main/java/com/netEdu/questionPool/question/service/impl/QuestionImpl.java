package com.netEdu.questionPool.question.service.impl;

import com.netEdu.entity.Option;
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
        System.out.println(question.getQuestion_id());
    }

    @Override
    public void addOption(Option option){
        questionMapper.insertOption(option);
    }

    @Override
    public void del(String ids){
        questionMapper.logidel(ids);
    }

    @Override
    public void update(Question question){
        questionMapper.updateByPrimaryKeySelective(question);
    }

    @Override
    public Question findOne(int id) {
        return questionMapper.queryOne(id);
    }

    @Override
    public List<Question> findAllByCriteria(Question question) {
        return questionMapper.queryAll(question);
    }

}
