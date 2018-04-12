package com.netEdu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class StudentData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int data_id;

    private String data_title;

    private int student_id;

    private int course_id;

    private String savepath;

    private String data_type;

    private String upload_time;

    private String del_flag;

}
