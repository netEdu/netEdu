package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 学生自评表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:41
 */
@Data
@Entity
@Table(name = "s_evaluate")
public class StudentEvaluate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evaluate_id;

    private int student_id;

    private int ideology;

    private int study;

    private int morality;

}
