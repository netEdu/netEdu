package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:  调查问卷表
 * User: Lei
 * Date: 2018-04-03
 * Time: 13:52
 */
@Data
public class Questionnaire {
    private int questionnaire_id;
    private String creator;
    private String survey_questions;
    private String create_time;
    private String remarks;
    private String teacher_ids;
    private String del_flag;


}
