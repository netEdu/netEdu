package com.netEdu.exam.check.service.impl;

import com.netEdu.entity.Answer;
import com.netEdu.entity.Score;
import com.netEdu.exam.check.dao.CheckMapper;
import com.netEdu.exam.check.dao.ScoreMapper;
import com.netEdu.exam.check.service.CheckService;
import com.netEdu.paper.dao.PaperMapper;
import com.netEdu.questionPool.question.dao.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CheckImpl implements CheckService{
    @Autowired
    private CheckMapper checkMapper;
    @Autowired
    private PaperMapper paperMapper;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public Map<String,Object> check(Answer answer) {
                        //往数据库记录学生答案
        this.addAnswer(answer);
                        //得到此卷子正确答案
        String answerForPaper= paperMapper.selectAnswerForPaper(answer.getPaper_id());
       /* .................................................................................................*/
                        //查询此卷子由那些问题组成
        String selectQuestionsForPaper= paperMapper.selectQuestionsForPaper(answer.getPaper_id());
        String[] QuestionIds=selectQuestionsForPaper.split(",");


                        //问题初次次数+1
        questionMapper.upFrequency(selectQuestionsForPaper);

        String[] answerForPaperList = answerForPaper.split(",");

        /*.................................................................................................*/

        String[] RightAnswer= answerForPaperList;
        //String[] RightAnswer= this.getRightAnswer(answer);


                        //得到学生的答案
        String[] StudentAnswer = answer.getStudent_answers().split(",");
        List flashAnswer =new ArrayList();
                        //判断那个题错了，得到学生的错误答案
        List flashNumber = new ArrayList();

        //声明错误问题id组；
        String flashQuestionIds="";

        for (int i=0;i<StudentAnswer.length;i++){
            if (!StudentAnswer[i].equals(RightAnswer[i])){// i:第几题
                flashAnswer.add(answerForPaperList[i]);
                System.out.println(QuestionIds[i]);
                flashQuestionIds=QuestionIds[i]+","+flashQuestionIds;
                flashNumber.add(i+1);
            }
        }
        String lastflashQuestionIds=flashQuestionIds.substring(0,flashQuestionIds.length()-1);
        System.out.println(lastflashQuestionIds);
                        //添加错误次数
        questionMapper.upError_times(lastflashQuestionIds);
        //questionMapper.upError_times(String.join(",", flashAnswer));

                        //计算分数
        Score score=new Score();
        score.setPaper_id(answer.getPaper_id());
        score.setStudent_id(answer.getStudent_id());



        int a=RightAnswer.length-flashAnswer.size();
        int b=RightAnswer.length;

        DecimalFormat decimalFormat=new DecimalFormat("0.00");

        String scoreNumber=decimalFormat.format(a/(float)b);

        Double cny = Double.parseDouble(scoreNumber)*100;
        int aaa = (new Double(cny)).intValue();



        score.setPaper_score(aaa);
        //score.setPaper_score((50-flashAnswer.size())*2);
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        score.setScore_time(df.format(day));
        scoreMapper.insertSelective(score);

        //返回map
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("rightAnswer",answerForPaper);
        resultMap.put("studentAnswer",answer.getStudent_answers());
        resultMap.put("flashNmuber",flashNumber);
        resultMap.put("score",aaa);

        return resultMap;
    }

    @Override
    public void addAnswer(Answer answer) {
        checkMapper.insertSelective(answer);
    }

    /*@Override
    public String[] getRightAnswer(Answer answer ) {
        //查询此卷子由那些问题组成
        String answerForPaper= paperMapper.selectAnswerForPaper(answer.getPaper_id());
        //问题初次次数+1
        questionMapper.upFrequency(answerForPaper);

        String[] answerForPaperList = answerForPaper.split(",");
        return answerForPaperList;
    }*/
}
