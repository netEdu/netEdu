package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description: 问卷问题表
 * User: Lei
 * Date: 2018-04-03
 * Time: 13:56
 */
@Data
@Entity
public class SurveyQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;

    private String creator;

    private String survey_content;

    private String survey_type;

    private String del_flag;

}
