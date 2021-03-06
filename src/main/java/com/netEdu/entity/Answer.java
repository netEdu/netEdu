package com.netEdu.entity;

import com.netEdu.core.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * Description: 答案表
 * User: Lei
 * Date: 2018-04-04
 * Time: 13:34
 */
@Data
@Entity
@Table(name = "answer")
public class Answer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answer_id;

    private int paper_id;

    private int student_id;

    private String student_answers;

}
