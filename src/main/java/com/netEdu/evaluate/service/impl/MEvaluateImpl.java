package com.netEdu.evaluate.service.impl;

import com.netEdu.entity.MEvaluate;
import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.MEvaluateVO;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.dao.MEvaluateMapper;
import com.netEdu.evaluate.dao.StudentEvaluateMapper;
import com.netEdu.evaluate.page.MEvaluatePage;
import com.netEdu.evaluate.page.StudentEvaluatePage;
import com.netEdu.evaluate.service.MEvaluateService;
import com.netEdu.evaluate.service.StudentEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-05-04
 * Time: 20:44
 */
@Service
public class MEvaluateImpl implements MEvaluateService{
    @Autowired
    private MEvaluateMapper mapper;


    @Override
    public void add(MEvaluate mEvaluate) {
        mapper.insertSelective(mEvaluate);
    }

    @Override
    public List<MEvaluateVO> SelectByStudentId(MEvaluatePage page) {
        Integer rowCount = mapper.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        return mapper.queryByPage(page);
    }

    @Override
    public void del(String student_id) {
        mapper.del(student_id);
    }
}
