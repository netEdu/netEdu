package com.netEdu.exam.check.dao;

import com.netEdu.core.BaseMapper;
import com.netEdu.entity.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CheckMapper extends BaseMapper<Answer> {



}
