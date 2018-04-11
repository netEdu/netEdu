package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description: 试卷表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:36
 */
@Data
@Entity
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paper_id;

    private String paper_name;

    private int teacher_id;

    private String questions;

    private String create_date;

    private String correct_answers;

    private String remarks;

    private String del_flag;

}
