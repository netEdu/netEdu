package com.netEdu.paper.service.impl;

import com.netEdu.entity.Paper;
import com.netEdu.entity.Question;
import com.netEdu.paper.dao.PaperMapper;
import com.netEdu.paper.service.PaperService;
import com.netEdu.paper.vo.PaperPage;
import com.netEdu.questionPool.question.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PaperImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public void add(Paper paper){
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //当前时间 df.format(date)
        String[] questions = paper.getQuestions().split(",");
        int[] questionArray= new int[questions.length];
        String answers = "";
        for (int i = 0;i < questionArray.length;i ++){
            questionArray[i] = Integer.parseInt(questions[i]);
            answers += questionMapper.selectPaperAnswer(questionArray[i]) + ",";
        }
        String paperAnswers = answers.substring(0,answers.length() - 1);
        paper.setCreate_date(df.format(date));
        paper.setCorrect_answers(paperAnswers);
        paperMapper.insertSelective(paper);
    }

    @Override
    public List<Paper> queryPaperListByCriteria(PaperPage paperPage) {
        Integer rowCount = paperMapper.queryByCount(paperPage);
        paperPage.getPager().setRowCount(rowCount);
        paperPage.setPage(paperPage.getPager().getStartIndex() - 1);
        return paperMapper.showPaperList(paperPage);
    }

    @Override
    public List<Question> queryOnePaper(int id){
        return paperMapper.showPaper(paperMapper.selectQuestionForPaper(id));
    }

    @Override
    public void del(String ids) {
        paperMapper.deletePaper(ids);
    }

    @Override
    public void updatePaper(Paper paper) {
        if (paper.getQuestions() != null && paper.getQuestions() != "") {
            String[] questions = paper.getQuestions().split(",");
            String answers = "";
            if (questions.length != 0){
                int[] questionArray = new int[questions.length];
                for (int i = 0; i < questionArray.length; i++) {
                    questionArray[i] = Integer.parseInt(questions[i]);
                    answers += questionMapper.selectPaperAnswer(questionArray[i]) + ",";
                }
                String paperAnswers = answers.substring(0, answers.length() - 1);
                paper.setCorrect_answers(paperAnswers);
            }
            paperMapper.updateByPrimaryKeySelective(paper);
        }else {
            paperMapper.upQuestionsnull(paper);
        }
    }

}
