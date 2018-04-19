package com.netEdu.admin.person.teacher.vo;

import com.adc.da.base.page.BasePage;
import lombok.Data;

@Data
public class TeacherPage extends BasePage {

    private Integer pageSize = 2;

    private int teacher_id;

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

    private String position;

}
