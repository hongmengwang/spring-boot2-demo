package com.wanghongmeng.demo.spring.boot2.dao.test;

import com.wanghongmeng.demo.spring.boot2.BaseTest;
import com.wanghongmeng.demo.spring.boot2.dao.DepartmentDao;
import com.wanghongmeng.demo.spring.boot2.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@DisplayName("Test DepartmentDao")
class DepartmentDaoTest extends BaseTest {

    @Autowired
    private DepartmentDao departmentDao;

    @Test
    @DisplayName("Get All Departments")
    void testGet() {
        departmentDao.add(department);
        List<Department> departmentList = departmentDao.get();
        Assertions.assertNotNull(departmentList);
        Assertions.assertTrue(departmentList.size() > 0);
    }

    @Test
    @DisplayName("Get Department By Id")
    void testGetById() {
        int id = departmentDao.add(department);
        Department d1 = departmentDao.getById(id);
        Assertions.assertNotNull(d1);
        Assertions.assertEquals(d1.getName(), department.getName());
        Assertions.assertEquals(d1.getFloor(), department.getFloor());
        Assertions.assertEquals(d1.getCreatedBy(), department.getCreatedBy());
        Assertions.assertEquals(d1.getUpdatedBy(), department.getUpdatedBy());
    }

    @Test
    @DisplayName("Add Department")
    void testAdd() {
        int id = departmentDao.add(department);
        Assertions.assertNotEquals(0, id);
    }

    @Test
    @DisplayName("Delete Department By Id")
    void testDelete() {
        int id = departmentDao.add(department);
        Department department = departmentDao.getById(id);
        Assertions.assertNotNull(department);

        departmentDao.delete(id);
        department = departmentDao.getById(1);
        Assertions.assertNull(department);
    }

    @Test
    @DisplayName("Update Department")
    void testUpdate() {
        departmentDao.add(department);
        int id = department.getId();
        Department d1 = departmentDao.getById(id);
        Assertions.assertNotNull(d1);

        d1.setName(d1.getName() + d1.getName());
        d1.setFloor(d1.getFloor() + d1.getFloor());
        departmentDao.update(d1);

        Department d2 = departmentDao.getById(id);
        Assertions.assertNotNull(d2);
        Assertions.assertEquals(d2.getName(), d1.getName());
        Assertions.assertEquals(d2.getFloor(), d1.getFloor());
    }
}
