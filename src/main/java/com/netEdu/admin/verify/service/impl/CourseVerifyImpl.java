package com.netEdu.admin.verify.service.impl;

import com.netEdu.admin.verify.dao.CourseVerifyMapper;
import com.netEdu.admin.verify.service.CourseVerifyService;
import com.netEdu.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseVerifyImpl implements CourseVerifyService {

    @Autowired
    private CourseVerifyMapper courseVerifyMapper;

    @Override
    public List<Course> queryCourseList(Course course) {
        if (course.getAudit_status().equals("1")){
            course.setAudit_status("1,2");
        }
        return courseVerifyMapper.selectCourseList(course);
    }

    @Override
    public void verify(Course course) {
        course.setAuditor("管理员");
        courseVerifyMapper.updateByPrimaryKeySelective(course);
    }

}
