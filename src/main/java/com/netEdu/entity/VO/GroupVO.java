package com.netEdu.entity.VO;

import com.netEdu.entity.Group;
import com.netEdu.entity.Student;
import com.netEdu.entity.Teacher;
import lombok.Data;

import java.util.List;
@Data
public class GroupVO extends Group {
    private List<Student> studentList;
    private List<Teacher> teacherList;

}
