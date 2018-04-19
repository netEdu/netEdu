package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 教师资料表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:51
 */
@Data
@Entity
@Table(name = "teacher_data")
public class TeacherData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int data_id;

    private String data_title;

    private int teacher_id;

    private int course_id;

    private String share;

    private String savepath;

    private String data_type;

    private String upload_time;

    @Transient
    private String course_name;

    /**
     * 联表查询教师姓名
     */
    @Transient
    private String name;

    @Transient
    private String class_num;

}
