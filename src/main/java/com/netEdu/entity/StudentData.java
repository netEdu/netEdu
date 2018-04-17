package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.File;

@Data
@Entity
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

}
