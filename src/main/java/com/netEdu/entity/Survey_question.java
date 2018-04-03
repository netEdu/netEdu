package com.netEdu.entity;

import lombok.Data;

@Data
public class Survey_question {

    private String questionnaire_id;
    private String creator;
    private String survey_questions;
    private String create_time;
    private String remarks;
    private String teacher_ids;
    private String del_flag;

}
