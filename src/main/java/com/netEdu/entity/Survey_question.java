package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Survey_question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String questionnaire_id;

    private String creator;

    private String survey_questions;

    private String create_time;

    private String remarks;

    private String teacher_ids;

    private String del_flag;

}
