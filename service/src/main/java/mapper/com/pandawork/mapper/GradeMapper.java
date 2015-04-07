package com.pandawork.mapper;

import com.pandawork.common.entity.Grade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GradeMapper
 *
 * @author: zhangteng
 * @time: 2015/3/25 10:25
 */
public interface GradeMapper {

    public void newGrade(@Param("grade") Grade grade) throws Exception;

    public void update(@Param("grade") Grade grade) throws Exception;

    public Grade queryById(@Param("id") int id) throws Exception;

    public List<Grade> listAll() throws Exception;

    public void deleteById(@Param("id") int id) throws Exception;
}
