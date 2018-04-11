package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description: 学生自评表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:41
 */
@Data
@Entity
public class StudentEvaluate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluate_id;

    private int student_id;

    private int ideology;

    private int study;

    private int morality;

    private String del_flag;

}
