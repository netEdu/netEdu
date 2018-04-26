package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 学生互评表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:38
 */
@Data
@Entity
@Table(name = "m_evaluate")
public class MEvaluate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluate_id;

    private int student_id;

    private int ideology;

    private int study;

    private int morality;

}
