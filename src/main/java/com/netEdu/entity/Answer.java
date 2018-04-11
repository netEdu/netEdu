package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description: 答案表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:34
 */
@Data
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answer_id;

    private int paper_id;

    private int student_id;

    private String student_answers;

    private String del_flag;

}
