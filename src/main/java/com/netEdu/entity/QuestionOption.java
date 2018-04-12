package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * Description:  选项表
 * User: Lei
 * Date: 2018-04-03
 * Time: 14:39
 */
@Data
@Entity
public class QuestionOption extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int option_id;

    private int question_id;

    private String option_content;

}
