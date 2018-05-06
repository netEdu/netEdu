package com.netEdu.evaluate.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.MEvaluate;
import com.netEdu.entity.StudentEvaluate;
import com.netEdu.entity.VO.MEvaluateVO;
import com.netEdu.entity.VO.StudentEvaluateVO;
import com.netEdu.evaluate.page.MEvaluatePage;
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
public interface MEvaluateMapper extends BaseMapper<MEvaluate>{
    @Select("SELECT COUNT(1) FROM m_evaluate WHERE student_id=#{student_id} and del_flag=0")
    Integer queryByCount(MEvaluatePage page);

    List<MEvaluateVO> queryByPage(MEvaluatePage page);

    @Update("update m_evaluate set del_flag = 1 where FIND_IN_SET(student_id,#{0})")
    void del(String ids);
}
