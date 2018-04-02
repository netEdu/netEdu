package com.netEdu.entity;

import lombok.Data;

@Data
public class Student {
    private int student_id;
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
    private String class_num;
    private String del_flag;


}