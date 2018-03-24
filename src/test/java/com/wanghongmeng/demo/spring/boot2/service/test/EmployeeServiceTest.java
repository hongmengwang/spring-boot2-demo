package com.wanghongmeng.demo.spring.boot2.service.test;

import com.wanghongmeng.demo.spring.boot2.BaseTest;
import com.wanghongmeng.demo.spring.boot2.dao.EmployeeDao;
import com.wanghongmeng.demo.spring.boot2.entity.Employee;
import com.wanghongmeng.demo.spring.boot2.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

@SpringBootTest
@DisplayName("Test EmployeeService")
class EmployeeServiceTest extends BaseTest {

    @MockBean
    private EmployeeDao employeeDao;
    @Autowired
    private EmployeeService employeeService;

    @Test
    @DisplayName("Get All Employees")
    void testGet() {
        BDDMockito.given(employeeDao.get()).willReturn(Collections.emptyList());
        List<Employee> employeeList = employeeService.get();
        Assertions.assertNotNull(employeeList);
    }

    @Test
    @DisplayName("Get Employee By Id")
    void testGetById() {
        int id = 1;
        BDDMockito.given(employeeDao.getById(id)).willReturn(employee);
        Employee dbEmployee = employeeDao.getById(id);
        Assertions.assertNotNull(dbEmployee);
        Assertions.assertEquals(dbEmployee.getName(), employee.getName());
        Assertions.assertEquals(dbEmployee.getDepartmentId(), employee.getDepartmentId());
        Assertions.assertEquals(dbEmployee.getEmployeeNo(), employee.getEmployeeNo());
        Assertions.assertEquals(dbEmployee.getCreatedBy(), employee.getCreatedBy());
        Assertions.assertEquals(dbEmployee.getUpdatedBy(), employee.getUpdatedBy());
    }

    @Test
    @DisplayName("Add Employee")
    void testAdd() {
        BDDMockito.given(employeeDao.add(employee)).willReturn(1);
        int id = employeeService.add(employee);
        Assertions.assertEquals(1, id);
    }
}
