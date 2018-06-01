package com.netEdu.exam.check.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Score;
import com.netEdu.entity.VO.ScoreVO;
import com.netEdu.exam.check.page.ScorePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    //单个学生的平均成绩
    @Select("SELECT AVG(score.paper_score) AS paper_score ," +
            "AVG(score.sign_score) AS sign_score, " +
            "AVG(score.test_score) AS test_score, " +
            "AVG(student_data.backup) AS data_score " +
            "FROM score " +
            "left join student_data " +
            "on score.student_id = student_data.student_id " +
            "WHERE score.student_id = #{0} GROUP BY score.student_id")
    ScoreVO AVGStudentId(int student_id);

    //所有学生的平均成绩
    @Select("<script>SELECT AVG(score.paper_score) AS paper_score ," +
            "AVG(score.sign_score) AS sign_score, " +
            "AVG(score.test_score) AS test_score, " +
            "AVG(student_data.backup) AS data_score , " +
            " student.`name` AS student_name " +
            "FROM score " +
            "left join student_data " +
            "on score.student_id = student_data.student_id " +
            " LEFT JOIN student " +
            "ON student.student_id = score.student_id " +
            "where 1=1" +
            "<if test=\"class_num !=0 \"> and student.class_num = #{class_num}</if> " +
            "<if test=\"student_name !=null and student_name != '' \"> and student.`name` LIKE concat('%',#{student_name},'%')</if> " +
            "<if test=\"student_id !=0 \"> and student.student_id = #{student_id}</if> "+
            " GROUP BY score.student_id</script>")
    List<ScoreVO> AVGAllStudentId(ScorePage classRequirement);
}
