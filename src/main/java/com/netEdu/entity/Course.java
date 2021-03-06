package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 课程表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:46
 */
@Data
@Entity
@Table(name = "course")
public class Course extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    private String course_name;

    private String credit;

    private String hours;

    private String teacher_id;

    private String class_time;

    private String course_introduce;

    private String class_num;

    private String assessment_method;

    private String create_time;

    private String audit_status;

    private String audit_opinion;

    private String auditor;

    /** 联表查询教师姓名 */
    @Transient
    private String name;

}
