package com.wanghongmeng.demo.spring.boot2.controller;

import com.wanghongmeng.demo.spring.boot2.dto.ResponseEntity;
import com.wanghongmeng.demo.spring.boot2.entity.Department;
import com.wanghongmeng.demo.spring.boot2.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/departments")
@Api(tags = "Department APIs", description = "APIs of Department's CRUD")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("")
    @ApiOperation(value = "Get All Departments", tags = "v1")
    public Flux<ResponseEntity> get() {
        List<Department> departmentList = departmentService.get();
        return Flux.just(new ResponseEntity(departmentList));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Department By Id", tags = "v1")
    public Mono<ResponseEntity> getById(@PathVariable int id) {
        Department department = departmentService.getById(id);
        return Mono.just(new ResponseEntity(department));
    }

    @PostMapping(value = "")
    @ApiOperation(value = "Add Department", tags = "v1")
    public Mono<ResponseEntity>  add(@RequestBody Department department) {
        Department result = departmentService.add(department);
        return Mono.just(new ResponseEntity(result));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Department By Id", tags = "v1")
    public Mono<ResponseEntity> delete(@PathVariable int id) {
        departmentService.delete(id);
        return Mono.just(new ResponseEntity(id));
    }

    @PutMapping("")
    @ApiOperation(value = "Update Department", tags = "v1")
    public Mono<ResponseEntity> update(@RequestBody Department department) {
        int count = departmentService.update(department);
        return Mono.just(new ResponseEntity(count));
    }
}
