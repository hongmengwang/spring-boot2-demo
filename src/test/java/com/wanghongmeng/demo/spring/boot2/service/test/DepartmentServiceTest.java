package com.wanghongmeng.demo.spring.boot2.service.test;

import com.wanghongmeng.demo.spring.boot2.BaseTest;
import com.wanghongmeng.demo.spring.boot2.dao.DepartmentDao;
import com.wanghongmeng.demo.spring.boot2.entity.Department;
import com.wanghongmeng.demo.spring.boot2.service.DepartmentService;
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
@DisplayName("Test DepartmentService")
class DepartmentServiceTest extends BaseTest {

    @MockBean
    private DepartmentDao departmentDao;
    @Autowired
    private DepartmentService departmentService;

    @Test
    @DisplayName("Get All Departments")
    void testGet() {
        BDDMockito.given(departmentDao.get()).willReturn(Collections.emptyList());
        List<Department> departmentList = departmentService.get();
        Assertions.assertNotNull(departmentList);
    }

    @Test
    @DisplayName("Get Department By Id")
    void testGetById() {
        int id = 1;
        BDDMockito.given(departmentDao.getById(id)).willReturn(department);
        Department dbDepartment = departmentDao.getById(id);
        Assertions.assertNotNull(dbDepartment);
        Assertions.assertEquals(dbDepartment.getName(), department.getName());
        Assertions.assertEquals(dbDepartment.getFloor(), department.getFloor());
        Assertions.assertEquals(dbDepartment.getCreatedBy(), department.getCreatedBy());
        Assertions.assertEquals(dbDepartment.getUpdatedBy(), department.getUpdatedBy());
    }

    @Test
    @DisplayName("Add Department")
    void testAdd() {
        BDDMockito.given(departmentDao.add(department)).willReturn(1);
        int id = departmentService.add(department);
        Assertions.assertEquals(1, id);
    }
}
