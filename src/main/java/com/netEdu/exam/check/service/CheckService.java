package com.netEdu.exam.check.service;

import com.netEdu.entity.Answer;

import java.util.List;
import java.util.Map;

public interface CheckService {
    Map<String,Object> check(Answer answer);

    void addAnswer(Answer answer);

    /*String[] getRightAnswer(Answer answer);*/
}
