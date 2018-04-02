package com.netEdu.entity;


import lombok.Data;

@Data
public class Group {

    private int group_id;
    private String group_num;
    private String group_name;
    private String person_id;
    private String del_flag;
}
