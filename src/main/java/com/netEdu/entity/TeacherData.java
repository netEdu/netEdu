package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 教师资料表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:51
 */
@Data
public class TeacherData {
    private int data_id;
    private String data_title;
    private int teacher_id;
    private int course_id;
    private String share;
    private String savepath;
    private String data_type;
    private String upload_time;
    private String del_flag;
}
