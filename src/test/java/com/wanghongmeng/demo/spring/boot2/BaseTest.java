package com.wanghongmeng.demo.spring.boot2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanghongmeng.demo.spring.boot2.entity.Department;
import com.wanghongmeng.demo.spring.boot2.entity.Employee;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@AutoConfigureTestDatabase
@ExtendWith(SpringExtension.class)
public abstract class BaseTest {

    protected static Employee employee;
    protected static Department department;

    static {
        department = new Department();
        department.setName("Data Science");
        department.setFloor(11);
        department.setCreatedBy("system");
        department.setUpdatedBy("system");

        employee = new Employee();
        employee.setName("wang");
        employee.setDepartmentId(0);
        employee.setEmployeeNo("00000001");
        employee.setCreatedBy("system");
        employee.setUpdatedBy("system");
    }

    protected ObjectMapper jsonMapper = new ObjectMapper();
}
