package com.netEdu.exam.check.dao;

import com.netEdu.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LZZ
 * Created by LZZ on 2018/5/29.
 */
@Mapper
public interface ExamMapper {

    @Select("select questions from paper where paper_id = #{0}")
    String selectQuestionForPaper(int id);

    @Select("select question_id," +
            "teacher_id," +
            "question_type," +
            "question_content," +
            "frequency," +
            "error_times," +
            "difficulty," +
            "backup " +
            "from question where FIND_IN_SET(question_id,#{0})")
    @ResultMap("ExamMap")
    List<Question> showPaper(String questions);

}
