package com.netEdu.client.student.service;

import com.netEdu.entity.Student;

public interface StudentClientService {

    Student personalInfo(int student_id);

    void updateInfo(Student student);

}
