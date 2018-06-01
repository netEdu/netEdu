package com.netEdu.paper.vo;

import com.adc.da.base.page.BasePage;
import lombok.Data;

@Data
public class PaperPage extends BasePage {

    private Integer pageSize = 10;

    private int paper_id;

    private String paper_name;

    private int teacher_id;

    private String questions;

    private String create_date;

    private String correct_answers;

    private String remarks;

    private String teacher_name;

    private String startDate;

    private String endDate;

}
