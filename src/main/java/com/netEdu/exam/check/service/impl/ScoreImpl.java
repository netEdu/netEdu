package com.netEdu.exam.check.service.impl;

import com.netEdu.exam.check.dao.ScoreMapper;
import com.netEdu.exam.check.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-23
 * Time: 16:03
 */
@Service
public class ScoreImpl implements ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
}
