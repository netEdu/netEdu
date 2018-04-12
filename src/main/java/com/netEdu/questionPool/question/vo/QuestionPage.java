package com.netEdu.questionPool.question.vo;

import com.adc.da.base.page.BasePage;
import lombok.Data;

@Data
public class QuestionPage extends BasePage {

    private Integer pageSize = 2;

    private int question_id;

    private int teacher_id;

    private String question_type;

    private String question_content;

    private String question_answer;

    private int frequency;

    private int error_times;

    private String difficulty;

    private String del_flag;

    private String options;

}
