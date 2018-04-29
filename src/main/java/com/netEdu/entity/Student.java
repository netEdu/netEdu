package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_id;

    private String username;

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

}