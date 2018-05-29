package com.netEdu.exam.check.service.impl;

import com.netEdu.entity.Question;
import com.netEdu.exam.check.dao.ExamMapper;
import com.netEdu.exam.check.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LZZ
 * Created by LZZ on 2018/5/29.
 */
@Service
public class ExamImpl implements ExamService {

    @Autowired
    private ExamMapper examMapper;

    @Override
    public List<Question> queryOnePaper(int id){
        return examMapper.showPaper(examMapper.selectQuestionForPaper(id));
    }

}
