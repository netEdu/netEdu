package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
public class Question implements Serializable{

    private String question_id;
    private String teacher_id;
    private String question_type;
    private String question_content;
    private String frequency;
    private String error_times;
    private String difficulty;
    private String del_flag;

}


