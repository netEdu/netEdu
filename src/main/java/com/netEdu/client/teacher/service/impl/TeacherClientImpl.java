package com.netEdu.client.teacher.service.impl;

import com.netEdu.client.teacher.dao.TeacherClientMapper;
import com.netEdu.client.teacher.service.TeacherClientService;
import com.netEdu.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherClientImpl implements TeacherClientService {

    @Autowired
    private TeacherClientMapper teacherClientMapper;

    @Override
    public Teacher personalInfo(int teacher_id) {
        return teacherClientMapper.selectById(teacher_id);
    }

    @Override
    public void updateInfo(Teacher teacher) {
        teacherClientMapper.updateByPrimaryKeySelective(teacher);
    }

}
