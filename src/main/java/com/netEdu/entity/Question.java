package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "question")
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

    /**
     * 新增问题所属章节
     */
    @Column(name = "backup")
    private String chapter;

    @Transient
    private String options;

    @Transient
    private int option_id;

    @Transient
    private String option_content;

    @Transient
    private String name;

    @Transient
    private List<QuestionOption> questionOptionList;

}


