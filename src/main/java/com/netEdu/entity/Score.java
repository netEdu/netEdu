package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description: 成绩表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:43
 */
@Data
@Entity
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int score_id;

    private int paper_id;

    private int student_id;

    private float paper_score;

    private float sign_score;

    private float test_score;

    private String score_time;

    private String del_flag;

}
