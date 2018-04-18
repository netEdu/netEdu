package com.netEdu.lesson.rate.page;

import com.adc.da.base.page.BasePage;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-17
 * Time: 10:49
 */
public class SurveyQuestionPage extends BasePage {
    private Integer pageSize = 2;
    private int question_id;

    private String creator;

    private String survey_content;

    private String survey_type;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSurvey_content() {
        return survey_content;
    }

    public void setSurvey_content(String survey_content) {
        this.survey_content = survey_content;
    }

    public String getSurvey_type() {
        return survey_type;
    }

    public void setSurvey_type(String survey_type) {
        this.survey_type = survey_type;
    }
}
