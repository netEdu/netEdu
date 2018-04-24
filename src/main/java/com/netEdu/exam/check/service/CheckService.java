package com.netEdu.exam.check.service;

import com.netEdu.entity.Answer;

import java.util.List;

public interface CheckService {
    List check(Answer answer);

    void addAnswer(Answer answer);

    /*String[] getRightAnswer(Answer answer);*/
}
