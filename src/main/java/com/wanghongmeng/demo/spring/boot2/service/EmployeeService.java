package com.wanghongmeng.demo.spring.boot2.service;

import com.wanghongmeng.demo.spring.boot2.dao.EmployeeDao;
import com.wanghongmeng.demo.spring.boot2.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> get() {
        return employeeDao.get();
    }

    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    public void delete() {
        employeeDao.delete();
    }

    public int add(Employee employee) {
        return employeeDao.add(employee);
    }

    public List<Employee> query(String employeeNo) {
        return employeeDao.query(employeeNo);
    }
}
