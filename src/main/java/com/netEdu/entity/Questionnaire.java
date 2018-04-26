package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:  调查问卷表
 * User: Lei
 * Date: 2018-04-03
 * Time: 13:52
 */
@Data
@Entity
@Table(name = "questionnaire")
public class Questionnaire extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionnaire_id;

    private int questionnaire_name;

    private String creator;

    /**
     * 问题id组
     */
    private String survey_questions;

    private String create_time;

    /**
     * 问卷说明
     */
    private String remarks;

    private int teacher_id;

    /**
     * 问卷问题List
     */
    @Transient
    private List<SurveyQuestion> surveyQuestionList;

}
