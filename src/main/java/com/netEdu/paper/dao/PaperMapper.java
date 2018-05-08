package com.netEdu.paper.dao;


import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Paper;
import com.netEdu.entity.Question;
import com.netEdu.paper.vo.PaperPage;
import com.netEdu.questionPool.question.vo.QuestionPage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PaperMapper extends BaseMapper<Paper> {

    /**
     * 表中多少条数据
     * @param paperPage
     * @return
     */
    @Select("<script>select count(1) from paper " +
            "<if test=\"teacher_name !=null and teacher_name != '' \">and teacher_name like CONCAT(CONCAT('%',#{teacher_name},'%')) </if> " +
            "<if test=\"paper_name !=null and paper_name != '' \">and paper_name like CONCAT(CONCAT('%',#{paper_name},'%')) </if> " +
            "<if test=\"remarks !=null and remarks != '' \">and remarks like CONCAT(CONCAT('%',#{remarks},'%')) </if> " +
            "<if test=\"startDate !=null and startDate != '' and endDate !=null and endDate !='' \">and create_date between #{startDate} and #{endDate} </if> </script>" )
    Integer queryByCount(PaperPage paperPage);

    @Select("<script>select paper_id," +
            "paper_name," +
            "paper.teacher_id," +
            "paper.questions," +
            "paper.correct_answers," +
            "name as teacher_name," +
            "remarks," +
            "create_date " +
            "from paper left join teacher on paper.teacher_id = teacher.teacher_id where 1=1" +
            "<if test=\"teacher_name !=null and teacher_name != '' \">and teacher_name like CONCAT(CONCAT('%',#{teacher_name},'%')) </if> " +
            "<if test=\"paper_name !=null and paper_name != '' \">and paper_name like CONCAT(CONCAT('%',#{paper_name},'%')) </if> " +
            "<if test=\"remarks !=null and remarks != '' \">and remarks like CONCAT(CONCAT('%',#{remarks},'%')) </if> " +
            "<if test=\"startDate !=null and startDate != '' and endDate !=null and endDate !='' \">and create_date between #{startDate} and #{endDate} </if> " +
            "and paper.del_flag = 0 limit #{page},#{pageSize} " +
            "</script>"
    )
    List<Paper> showPaperList(PaperPage paperPage);

    @Select("select questions from paper where paper_id = #{0}")
    String selectQuestionForPaper(int id);

    @Select("select * from question where FIND_IN_SET(question_id,#{0})")
    @ResultMap("BaseResultMap")
    List<Question> showPaper(String questions);

    @Update("update Paper set del_flag = 1 where FIND_IN_SET(paper_id,#{0})")
    void deletePaper(String ids);

    @Select("select correct_answers from paper where paper_id = #{0}")
    String selectAnswerForPaper(int id);

    @Update("UPDATE paper SET questions = NULL,correct_answers = NULL WHERE paper_id = #{paper_id}")
    void upQuestionsnull(Paper paper);

}
