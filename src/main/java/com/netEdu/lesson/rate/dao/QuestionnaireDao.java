package com.netEdu.lesson.rate.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Questionnaire;
import com.netEdu.entity.SurveyQuestion;
import com.netEdu.entity.VO.QuestionnaireVO;
import com.netEdu.lesson.rate.page.QuestionnairePage;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-13
 * Time: 16:33
 */

@Mapper
public interface QuestionnaireDao extends BaseMapper<Questionnaire> {

    /**
     * 批量删除
     * @param ids
     */
    @Update("update questionnaire set del_flag = 1 where FIND_IN_SET(questionnaire_id,#{0})")
    void deleteQuestionnaire(String ids);

    /**
     * 查找条数
     * @param page
     * @return
     */
    @Select("select count(1) from questionnaire where del_flag = 0")
    Integer queryByCount(QuestionnairePage page);

    /**
     * 查找分页数据
     * @param page
     * @return
     */
    List<QuestionnaireVO> queryByPage(QuestionnairePage page);

    /**
     * 查一份问卷的所有题 一个字符串
     * @param questionnaire_id
     * @return
     */
    @Select("select survey_questions from questionnaire where questionnaire_id = #{0} and del_flag = 0")
    String selectSurveyQuestion(int questionnaire_id);

    /**
     * 查找整个单卷
     * @param surveyQuestions
     * @return
     */
    @Select("select * from survey_question where FIND_IN_SET(question_id,#{0}) and del_flag = 0")
    List<SurveyQuestion> selectByQuestionnaireId(String surveyQuestions);

    /**
     * 查询所有教师问卷
     */
    List<QuestionnaireVO> selectAllQuestionnarire();
}
