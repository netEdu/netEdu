package com.netEdu.lesson.rate.dao;

import com.netEdu.entity.TeacherEvaluate;
import com.netEdu.lesson.rate.page.TeacherEvaluatePage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-04-03
 * Time: 15:01
 */
@Mapper
public interface TeacherEvaluateDao {
    //增加教师评价
    void addTeacherEvaluate(TeacherEvaluate teacherEvaluate);

    //分页查询
    List<TeacherEvaluate> queryByPage(TeacherEvaluatePage page);

    //表中多少条数据
    Integer queryByCount(TeacherEvaluatePage page);

    //更新教师评价
    void upTeacherEvaluate(TeacherEvaluate teacherEvaluate);
}
