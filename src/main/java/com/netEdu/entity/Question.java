package com.netEdu.entity;

import lombok.Data;

@Data
public class Question {

    private String question_id;
    private String teacher_id;
    private String question_type;
    private String question_content;
    private String frequency;
    private String error_times;
    private String difficulty;
    private String del_flag;

}


