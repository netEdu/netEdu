package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description: 教师评价表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:33
 */
@Data
@Entity
public class TeacherEvaluate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluate_id;

    private int questionnaire_id;

    private int student_id;

    private String answers;

    private String del_flag;

}
