package com.netEdu.entity;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 教师评价表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:33
 */
@Data
public class TeacherEvaluate {
    private int evaluate_id;
    private int questionnaire_id;
    private int student_id;
    private String answers;
    private String del_flag;
}
