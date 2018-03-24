package com.wanghongmeng.demo.spring.boot2.dao;

import com.wanghongmeng.demo.spring.boot2.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentDao {
    @Select("SELECT * FROM department")
    List<Department> get();

    @Select("SELECT * FROM department where id = #{id}")
    Department getById(@Param("id") int id);

    int add(Department department);

    @Select("DELETE FROM department WHERE id = #{id}")
    void delete(@Param("id") int id);

    int update(Department department);
}
