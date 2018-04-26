package com.netEdu.exam.check.service.impl;

import com.netEdu.entity.VO.ScoreVO;
import com.netEdu.exam.check.dao.ScoreMapper;
import com.netEdu.exam.check.page.ScorePage;
import com.netEdu.exam.check.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<ScoreVO> queryByPage(ScorePage page) {
        Integer rowCount = scoreMapper.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        return scoreMapper.queryByPage(page);
    }

    @Override
    public List<ScoreVO> selectScoreByStudentId(ScorePage page) {
        Integer rowCount = scoreMapper.selectScoreByStudentIdCount(page);
        page.getPager().setRowCount(rowCount);
        return scoreMapper.selectScoreByStudentId(page);
    }

    @Override
    public ScoreVO AVGStudentId(int student_id) {
        return scoreMapper.AVGStudentId(student_id);
    }
}
