package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:  选项表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:39
 */
@Data
public class Option {
    private int option_id;
    private int question_id;
    private String option_content;
    private String del_flag;
}
