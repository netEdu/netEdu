package com.netEdu.evaluate.service;

import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.page.StudentEvaluatePage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-05-04
 * Time: 20:43
 */
public interface StudentEvaluateService {
    void add(StudentEvaluate studentEvaluate);


    List<StudentEvaluateVO> SelectByStudentId(StudentEvaluatePage page);

    void del(String ids);

    void updateStudentEvaluate(StudentEvaluate studentEvaluate);
}
