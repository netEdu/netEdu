package com.netEdu.lesson.apply.service.impl;

import com.netEdu.entity.Course;
import com.netEdu.lesson.apply.dao.CourseMapper;
import com.netEdu.lesson.apply.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CourseImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public String add(Course course) {
        if(courseMapper.queryCourse(course.getCourse_name()).size() > 0){
            return "REPEAT";
        }
        else{
            Date date=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            course.setCreate_time(df.format(date));
            course.setAudit_status("0");
            courseMapper.insertSelective(course);
        }
        return "SUCCESS";
    }

    @Override
    public void updateCourse(Course course) {
        //courseMapper.updateByPrimaryKeySelective(course);
        courseMapper.updateCourse(course);
    }

    @Override
    public void remove(String ids) {
        courseMapper.deleteCourse(ids);
    }

    @Override
    public List<Course> selectCourse(Course course) {
        return courseMapper.queryCourseList(course);
    }

}
