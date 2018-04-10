package com.netEdu.core;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * base mapper
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {

}
