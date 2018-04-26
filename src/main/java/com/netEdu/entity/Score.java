package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 成绩表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:43
 */
@Data
@Entity
@Table(name = "score")
public class Score extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int score_id;

    private int paper_id;

    private int student_id;

    private float paper_score;

    private float sign_score;

    private float test_score;

    private String score_time;

}
