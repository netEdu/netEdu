package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description:  调查问卷表
 * User: Lei
 * Date: 2018-04-03
 * Time: 13:52
 */
@Data
@Entity
public class Questionnaire extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionnaire_id;

    private int questionnaire_name;

    private String creator;

    private String survey_questions;//问题id组

    private String create_time;

    private String remarks;//问卷说明

    private int teacher_id;

}
