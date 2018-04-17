package com.netEdu.lesson.rate.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Questionnaire;
import com.netEdu.lesson.rate.page.QuestionnairePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
    //批量删除
    @Update("update questionnaire set del_flag = 1 where FIND_IN_SET(questionnaire_id,#{0})")
    void deleteQuestionnaire(String ids);

    //查找条数
    @Select("select count(1) from questionnaire where del_flag = 0")
    Integer queryByCount(QuestionnairePage page);

    //查找分页数据
    List<Questionnaire> queryByPage(QuestionnairePage page);

    Questionnaire selectByQuestionnaireId(@Param(value = "questionnaire_id") int questionnaire_id);
}
