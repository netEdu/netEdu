package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 教师表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:44
 */
@Data
public class Teacher {
    private int teacher_id;
    private String name;
    private String password;
    private String sex;
    private String identity;
    private String birth;
    private String origin;
    private String email;
    private String phone;
    private String head_pic;
    private String create_time;
    private String position;
    private String del_flag;
}
