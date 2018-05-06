package com.netEdu.evaluate.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.page.StudentEvaluatePage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Lei
 * Date: 2018-05-04
 * Time: 20:41
 */
@Mapper
public interface StudentEvaluateMapper extends BaseMapper<StudentEvaluate>{
    @Select("SELECT COUNT(1) FROM s_evaluate WHERE student_id=#{student_id} AND del_flag=0")
    Integer queryByCount(StudentEvaluatePage page);

    List<StudentEvaluateVO> queryByPage(StudentEvaluatePage page);

    @Update("update s_evaluate set del_flag = 1 where FIND_IN_SET(evaluate_id,#{0})")
    void del(String ids);
}
