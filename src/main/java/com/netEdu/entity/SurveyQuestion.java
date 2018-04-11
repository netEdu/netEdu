package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 问卷问题表
 * User: Lei
 * Date: 2018-04-03
 * Time: 13:56
 */
@Data
public class SurveyQuestion {
    private int question_id;
    private String creator;
    private String survey_content;
    private String survey_type;
    private String del_flag;
}
