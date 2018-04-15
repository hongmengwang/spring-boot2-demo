package com.wanghongmeng.demo.spring.boot2.service;

import com.wanghongmeng.demo.spring.boot2.dao.DepartmentDao;
import com.wanghongmeng.demo.spring.boot2.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> get() {
        return departmentDao.get();
    }

    public Department getById(int id) {
        return departmentDao.getById(id);
    }

    public Department add(Department department) {
        departmentDao.add(department);
        return department;
    }

    public void delete(int id) {
        departmentDao.delete(id);
    }

    public int update(Department department) {
        return departmentDao.update(department);
    }
}
