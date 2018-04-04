package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 学生互评表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:38
 */
@Data
public class MEvaluate {
    private int evaluate_id;
    private int student_id;
    private int ideology;
    private int study;
    private int morality;
    private String del_flag;
}
