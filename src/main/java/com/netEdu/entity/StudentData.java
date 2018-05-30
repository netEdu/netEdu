package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;

@Data
@Entity
@Table(name = "student_data")
public class StudentData extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int data_id;

    private String data_title;

    private int student_id;

    private int course_id;

    private String savepath;

    private String data_type;

    private String upload_time;

    @Transient
    private String course_name;

    /** 联表查询学生姓名 */
    @Transient
    private String name;

    @Transient
    private String class_num;

    /**
     * 备用字段变成资料成绩score
     */
    @Column(name = "backup")
    private String score;

}
