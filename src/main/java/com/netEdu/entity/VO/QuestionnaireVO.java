package com.netEdu.entity.VO;

import com.netEdu.entity.Questionnaire;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-23
 * Time: 9:58
 */
public class QuestionnaireVO extends Questionnaire {

    private int question_id;
    private String survey_content;
    private String survey_type;

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
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
