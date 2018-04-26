package com.netEdu.entity.VO;

import com.netEdu.entity.Score;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-24
 * Time: 8:49
 */
public class ScoreVO extends Score {
    private String student_name;
    private String paper_name;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPaper_name() {
        return paper_name;
    }

    public void setPaper_name(String paper_name) {
        this.paper_name = paper_name;
    }
}
