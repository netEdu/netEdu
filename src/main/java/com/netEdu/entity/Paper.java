package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 试卷表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:36
 */
@Data
public class Paper {
    private int paper_id;
    private String paper_name;
    private int teacher_id;
    private String questions;
    private String create_date;
    private String correct_answers;
    private String remarks;
    private String del_flag;
}
