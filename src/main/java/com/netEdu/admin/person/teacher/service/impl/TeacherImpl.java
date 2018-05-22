package com.netEdu.admin.person.teacher.service.impl;

import com.netEdu.admin.person.teacher.dao.TeacherMapper;
import com.netEdu.admin.person.teacher.service.TeacherService;
import com.netEdu.admin.person.teacher.vo.TeacherPage;
import com.netEdu.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TeacherImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public void addTeacher(Teacher teacher) {
        Date date=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        teacher.setCreate_time(df.format(date));
        teacher.setPassword("123456");
        teacherMapper.insertSelective(teacher);
    }

    @Override
    public List<Teacher> queryTeacher(TeacherPage teacherPage) {
        Integer rowCount = teacherMapper.queryByCount(teacherPage);
        teacherPage.getPager().setRowCount(rowCount);
        teacherPage.setPage(teacherPage.getPager().getStartIndex() - 1);
        return teacherMapper.selectTeacher(teacherPage);
    }

    @Override
    public String check(String username) {
        if(teacherMapper.checkTeacher(username).size() > 0){
            return "ALREADY EXIST";
        }
        return "COULD BE OK";
    }

    @Override
    public List<Teacher> selectAllTeacher() {
        return teacherMapper.selectAll();
    }

}
