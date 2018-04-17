package com.netEdu.lesson.rate.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.SurveyQuestion;
import com.netEdu.lesson.rate.page.SurveyQuestionPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-17
 * Time: 9:48
 */
@Mapper
public interface SurveyQuestionDao extends BaseMapper<SurveyQuestion> {
    @Update("update survey_question set del_flag = 1 where FIND_IN_SET(question_id,#{0})")
    void delSurveyQuestion(String question_ids);

    @Select("select count(1) from survey_question where del_flag = 0")
    Integer selectByCount(SurveyQuestionPage page);

    List<SurveyQuestion> selectByPage(SurveyQuestionPage page);

    SurveyQuestion selectByQuestionid(@Param(value = "question_id") int question_id);
}
