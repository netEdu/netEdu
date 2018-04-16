package com.netEdu.lesson.rate.page;

import com.adc.da.base.page.BasePage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-11
 * Time: 14:32
 */
public class TeacherEvaluatePage extends BasePage {
    private Integer pageSize = 2;
    private int evaluate_id;
    private int questionnaire_id;
    private int student_id;
    private String answers;
    private String del_flag;


    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(int evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }
}
