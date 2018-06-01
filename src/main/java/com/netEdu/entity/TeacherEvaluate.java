package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 教师评价表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:33
 */
@Data
@Entity
@Table(name = "t_evaluate")
public class TeacherEvaluate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluate_id;

    private int questionnaire_id;

    private int student_id;

    private String answers;

    private int teacher_id;

    @Transient
    private String name;
    @Transient
    private Student student;
    @Transient
    private Questionnaire questionnaire;

}
