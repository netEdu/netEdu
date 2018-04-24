package com.netEdu.client.teacher.service;

import com.netEdu.entity.Teacher;

public interface TeacherClientService {

    Teacher personalInfo(int teacher_id);

    void updateInfo(Teacher teacher);

}
