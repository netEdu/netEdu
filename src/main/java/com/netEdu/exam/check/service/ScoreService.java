package com.netEdu.exam.check.service;

import com.netEdu.entity.VO.ScoreVO;
import com.netEdu.exam.check.page.ScorePage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-23
 * Time: 16:02
 */
public interface ScoreService {
    List<ScoreVO> queryByPage(ScorePage page);

    //单个学生成绩列表
    List<ScoreVO> selectScoreByStudentId(ScorePage page);

    ScoreVO AVGStudentId(int student_id);
}
