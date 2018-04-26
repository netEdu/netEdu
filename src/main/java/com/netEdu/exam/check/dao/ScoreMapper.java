package com.netEdu.exam.check.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Score;
import com.netEdu.entity.VO.ScoreVO;
import com.netEdu.exam.check.page.ScorePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-23
 * Time: 16:01
 */
@Mapper
public interface ScoreMapper extends BaseMapper<Score>{

    @Select("select count(1) FROM score sc,student st,paper p " +
            "WHERE sc.del_flag=0 AND sc.paper_id=p.paper_id AND sc.student_id=st.student_id ")
    Integer queryByCount(ScorePage page);

    //分页查询
    List<ScoreVO> queryByPage(ScorePage page);

    //单个学生的所有成绩
    @Select("select count(1) FROM score sc,student st,paper p " +
            "WHERE sc.del_flag=0 AND sc.paper_id=p.paper_id AND sc.student_id=st.student_id AND sc.student_id=#{student_id}")
    Integer selectScoreByStudentIdCount(ScorePage page);

    //单个学生成绩数据
    List<ScoreVO> selectScoreByStudentId(ScorePage page);

    @Select("SELECT AVG(paper_score),AVG(sign_score),AVG(test_score)FROM score WHERE student_id=#{student_id} GROUP BY student_id")
    ScoreVO AVGStudentId(int student_id);
}
