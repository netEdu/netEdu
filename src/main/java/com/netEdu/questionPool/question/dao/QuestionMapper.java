package com.netEdu.questionPool.question.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Option;
import com.netEdu.entity.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    @Update("update question set del_flag = 1 where FIND_IN_SET(question_id,#{0})")
    void logidel(String ids);

    @Select("select * from question where question_id = #{0} and del_flag = 0")
    Question queryOne(int id);

    @Select("<script>select * from question where 1=1"
            +"<if test=\"question_type !=null and question_type != '' \">and question_type = #{question_type} </if> "
            +"<if test=\"question_content !=null and question_content != '' \">and question_content like CONCAT(CONCAT('%',#{question_content},'%')) </if> "
            +"<if test=\"difficulty !=null and difficulty != '' \">and difficulty = #{difficulty} </if> "
            +"<if test=\"frequency !=null and frequency != '' \">and frequency = #{frequency} </if> "
            +"<if test=\"error_times !=null and error_times != '' \">and error_times = #{error_times} </if> "
            +"<if test=\"teacher_id !=null and teacher_id != '' \">and teacher_id = #{teacher_id} </if> "
            +"and del_flag = 0 limit #{index},#{pageSize}"
            +"</script>"
    )
    List<Question> queryAll(Question question);

    @Insert("")
    void insertOption(Option option);

}
