package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;

    private int teacher_id;

    private String question_type;

    private String question_content;

    private int question_answer;

    private int frequency;

    private int error_times;

    private String difficulty;

    @Transient
    private String options;

}


