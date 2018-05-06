package com.netEdu.evaluate.service;

import com.netEdu.entity.MEvaluate;
import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.MEvaluateVO;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.page.MEvaluatePage;
import com.netEdu.evaluate.page.StudentEvaluatePage;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-05-04
 * Time: 20:43
 */
public interface MEvaluateService {

    void add(MEvaluate mEvaluate);

    List<MEvaluateVO> SelectByStudentId(MEvaluatePage page);

    void del(String student_id);
}
