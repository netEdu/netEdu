package com.netEdu.evaluate.page;

import com.adc.da.base.page.BasePage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-05-06
 * Time: 9:16
 */
public class StudentEvaluatePage extends BasePage {

    private Integer pageSize = 2;
    private int evaluate_id;

    private int student_id;

    private int ideology;

    private int study;

    private int morality;

    private String name;

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

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getIdeology() {
        return ideology;
    }

    public void setIdeology(int ideology) {
        this.ideology = ideology;
    }

    public int getStudy() {
        return study;
    }

    public void setStudy(int study) {
        this.study = study;
    }

    public int getMorality() {
        return morality;
    }

    public void setMorality(int morality) {
        this.morality = morality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
