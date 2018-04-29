package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 问卷问题表
 * User: Lei
 * Date: 2018-04-03
 * Time: 13:56
 */
@Data
@Entity
@Table(name = "survey_question")
public class SurveyQuestion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;

    private String creator;

    private String survey_content;

    private String survey_type;

}
