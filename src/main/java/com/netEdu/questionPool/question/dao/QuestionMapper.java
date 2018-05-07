package com.netEdu.questionPool.question.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Question;
import com.netEdu.entity.QuestionOption;
import com.netEdu.questionPool.question.vo.QuestionPage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    @Update("update question set del_flag = 1 where FIND_IN_SET(question_id,#{0})")
    void deleteQuestions(String ids);

    @Update("update question_option set option_content = #{1} where option_id = #{0}")
    void updateOptions(int option_id,String option_content);

    @Select("select * from question left join teacher on question.teacher_id = teacher.teacher_id where question.question_id = #{0} and question.del_flag = 0")
    Question queryOne(int id);

    @Select("select * from question_option where question_id = #{0} and del_flag = 0")
    List<QuestionOption> findOptions(int id);

    /**
     * 表中多少条数据
     * @param questionPage
     * @return
     */
    @Select("select count(1) from question")
    Integer queryByCount(QuestionPage questionPage);

    @Select("<script>select * from question left join teacher on question.teacher_id = teacher.teacher_id where 1=1 "
            +"<if test=\"question_type !=null and question_type != '' \">and question_type = #{question_type} </if> "
            +"<if test=\"question_content !=null and question_content != '' \">and question_content like CONCAT(CONCAT('%',#{question_content},'%')) </if> "
            +"<if test=\"name !=null and name != '' \">and name like CONCAT(CONCAT('%',#{name},'%')) </if> "
            +"<if test=\"difficulty !=null and difficulty != '' \">and difficulty = #{difficulty} </if> "
            +"<if test=\"frequency !=null and frequency != '' \">and frequency = #{frequency} </if> "
            +"<if test=\"error_times !=null and error_times != '' \">and error_times = #{error_times} </if> "
            +"<if test=\"teacher_id !=null and teacher_id != '' \">and teacher_id = #{teacher_id} </if> "
            +"and question.del_flag = 0 limit ${page-1},#{pageSize} "
            +"</script>"
    )
    @ResultMap("BaseResultMap")
    List<Question> queryAll(QuestionPage questionPage);

    @Insert("insert into question_option (question_id,option_content,del_flag) values(#{0},#{1},0)")
    void insertIntoOptions(int question_id,String options);

    @Select("select option_id from question_option where question_id = #{0} limit #{1},1")
    int selectAnswerForQuestion(int question_id,int question_answer);

    @Update("update question set question_answer = #{1} where question_id = #{0}")
    void selectIdToAnswer(int question_id,int option_id);

    @Select("select question_answer from question where question_id = #{0}")
    String selectPaperAnswer(int question_id);

    @Update("update question set frequency=frequency+1 where FIND_IN_SET(question_id,#{0})")
    void upFrequency(String answerForPaper);

    @Update("update question set error_times=error_times+1 where FIND_IN_SET(question_id,#{0})")
    void upError_times(String flashAnswer);

    @Select("<script>" +
            "select * from question where question.question_id NOT IN " +
            "<foreach collection=\"existQuestionIdList\" item=\"item\" separator=\",\">" +
            "(#{item})" +
            "</foreach>" +
            "</script>")
    @ResultMap("BaseResultMap")
    List<Question> selectNotExistQuestion(@Param("existQuestionIdList")List existQuestionIdList);
}
