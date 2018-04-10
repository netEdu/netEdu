package com.netEdu.questionPool.question.controller;

import com.netEdu.entity.Question;
import com.netEdu.questionPool.question.service.impl.QuestionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class QuestionController {

    @Autowired
    private QuestionImpl questionImpl;

    @PostMapping("/addQuestion")
    public void add(@RequestBody(required = false) Question question){
        questionImpl.add(question);
    }

}
