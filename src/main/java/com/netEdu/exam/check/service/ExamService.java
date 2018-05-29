package com.netEdu.exam.check.service;

import com.netEdu.entity.Question;

import java.util.List;

/**
 * @author LZZ
 * Created by LZZ on 2018/5/29.
 */
public interface ExamService {

    List<Question> queryOnePaper(int id);

}
