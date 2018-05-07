package com.netEdu.evaluate.service.impl;

import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.dao.StudentEvaluateMapper;
import com.netEdu.evaluate.page.StudentEvaluatePage;
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
public class StudentEvaluateImpl implements StudentEvaluateService{
    @Autowired
    private StudentEvaluateMapper mapper;

    //添加个人评价
    @Override
    public void add(StudentEvaluate studentEvaluate) {
        mapper.insertSelective(studentEvaluate);
    }

    @Override
    public List<StudentEvaluateVO> SelectByStudentId(StudentEvaluatePage page) {
        Integer rowCount = mapper.queryByCount(page);
        page.getPager().setRowCount(rowCount);
        return mapper.queryByPage(page);
    }

    @Override
    public void del(String ids) {
        mapper.del(ids);
    }

    @Override
    public void updateStudentEvaluate(StudentEvaluate studentEvaluate) {
        mapper.updateByPrimaryKey(studentEvaluate);
    }

}
