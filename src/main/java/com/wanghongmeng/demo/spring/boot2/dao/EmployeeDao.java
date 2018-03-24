package com.wanghongmeng.demo.spring.boot2.dao;

import com.wanghongmeng.demo.spring.boot2.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeDao {
    List<Employee> get();

    Employee getById(@Param("id") int id);

    @Select("DELETE FROM employee")
    void delete();

    int add(Employee employee);

    @Select("SELECT * FROM employee where employee_no like '%' || #{employeeNo} || '%'")
    List<Employee> query(@Param("employeeNo") String employeeNo);
}
