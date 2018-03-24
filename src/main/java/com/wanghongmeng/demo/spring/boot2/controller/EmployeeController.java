package com.wanghongmeng.demo.spring.boot2.controller;

import com.wanghongmeng.demo.spring.boot2.entity.Department;
import com.wanghongmeng.demo.spring.boot2.entity.Employee;
import com.wanghongmeng.demo.spring.boot2.resource.EmployeeResource;
import com.wanghongmeng.demo.spring.boot2.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/v1/employees")
@Api(tags = "Employee APIs", description = "APIs of Employee's CRUD")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Employees", tags = "v1")
    public ResponseEntity<Resources<EmployeeResource>> get() {
        List<Employee> employeeList = employeeService.get();
        return wrapResourceList(employeeList);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Employee By Id", tags = "v1")
    public ResponseEntity<EmployeeResource> getById(@PathVariable int id) {
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(new EmployeeResource(employee));
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Add Employee", tags = "v1")
    public ResponseEntity<EmployeeResource> add(@RequestBody Employee employee) {
        int id = employeeService.add(employee);
        URI uri = MvcUriComponentsBuilder.fromController(getClass())
                .path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(new EmployeeResource(employee));
    }

    @GetMapping("/query")
    @ApiOperation(value = "Query Employee By EmployeeNo", tags = "v1")
    public ResponseEntity<Resources<EmployeeResource>> query(@RequestParam("employee_no") String employeeNo) {
        List<Employee> employeeList = employeeService.query(employeeNo);
        return wrapResourceList(employeeList);
    }

    private ResponseEntity<Resources<EmployeeResource>> wrapResourceList(List<Employee> employeeList) {
        List<EmployeeResource> employees = employeeList.stream().map(EmployeeResource::new).collect(Collectors.toList());
        Resources<EmployeeResource> resources = new Resources<>(employees);
        String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }

    @GetMapping("/{id}/departments")
    @ApiOperation(value = "Get Employee's Departments", tags = "v1")
    public ResponseEntity<Department> getDepartments(@PathVariable int id) {
        Employee employee = employeeService.getById(id);
        return ResponseEntity.ok(employee.getDepartment());
    }
}