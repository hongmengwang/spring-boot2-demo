package com.wanghongmeng.demo.spring.boot2.dao.test;

import com.wanghongmeng.demo.spring.boot2.BaseTest;
import com.wanghongmeng.demo.spring.boot2.dao.DepartmentDao;
import com.wanghongmeng.demo.spring.boot2.dao.EmployeeDao;
import com.wanghongmeng.demo.spring.boot2.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("Test EmployeeDao")
class EmployeeDaoTest extends BaseTest {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @Test
    @DisplayName("Get All Employees")
    void testGet() {
        int departmentId = departmentDao.add(department);
        employee.setDepartmentId(departmentId);
        employeeDao.add(employee);
        List<Employee> employeeList = employeeDao.get();
        Assertions.assertNotNull(employeeList);
        Assertions.assertTrue(employeeList.size() > 0);
    }

    @Test
    @DisplayName("Get Employee By Id")
    void testGetById() {
        int departmentId = departmentDao.add(department);
        employee.setDepartmentId(departmentId);
        employeeDao.add(employee);
        int id = employee.getId();
        Employee e1 = employeeDao.getById(id);
        Assertions.assertNotNull(e1);
        Assertions.assertEquals(e1.getName(), employee.getName());
        Assertions.assertEquals(e1.getEmployeeNo(), employee.getEmployeeNo());
        Assertions.assertEquals(e1.getCreatedBy(), employee.getCreatedBy());
        Assertions.assertEquals(e1.getUpdatedBy(), employee.getUpdatedBy());
    }

    @Test
    @DisplayName("Add Employee")
    void testAdd() {
        int departmentId = departmentDao.add(department);
        employee.setDepartmentId(departmentId);
        employeeDao.add(employee);
        int id = employeeDao.add(employee);
        Assertions.assertNotEquals(0, id);
    }

    @Test
    @DisplayName("Delete All Employees")
    void testDelete() {
        employeeDao.add(employee);
        List<Employee> employeeList = employeeDao.get();
        Assertions.assertTrue(employeeList.size() > 0);

        employeeDao.delete();
        employeeList = employeeDao.get();
        Assertions.assertEquals(0, employeeList.size());
    }
}
