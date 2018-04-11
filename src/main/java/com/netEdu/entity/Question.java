package com.netEdu.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;

    private int teacher_id;

    private String question_type;

    private String question_content;

    private int frequency;

    private int error_times;

    private String difficulty;

    private String del_flag;

}


