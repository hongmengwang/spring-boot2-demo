//package com.wanghongmeng.demo.spring.boot2.controller;
//
//import com.wanghongmeng.demo.spring.boot2.dto.ResponseEntity;
//import com.wanghongmeng.demo.spring.boot2.entity.Department;
//import com.wanghongmeng.demo.spring.boot2.service.DepartmentService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/v1/webflux/departments")
//@Api(tags = "Department APIs", description = "APIs of Department's CRUD")
//public class WebFluxController {
//
//    private DepartmentService departmentService;
//
//    @Autowired
//    public WebFluxController(DepartmentService departmentService) {
//        this.departmentService = departmentService;
//    }
//
//    @GetMapping("")
//    @ApiOperation(value = "Get All Departments", tags = "v1")
//    public Mono<ResponseEntity> get() {
//        List<Department> departmentList = departmentService.get();
//        return Mono.justOrEmpty(new ResponseEntity(departmentList));
//    }
//
////    @GetMapping("/{id}")
////    @ApiOperation(value = "Get Department By Id", tags = "v1")
////    public ResponseEntity getById(@PathVariable int id) {
////        Department department = departmentService.getById(id);
////        return new ResponseEntity(department);
////    }
////
////    @PostMapping(value = "")
////    @ApiOperation(value = "Add Department", tags = "v1")
////    public ResponseEntity add(@RequestBody Department department) {
////        int id = departmentService.add(department);
////        return new ResponseEntity(id);
////    }
////
////    @DeleteMapping("/{id}")
////    @ApiOperation(value = "Delete Department By Id", tags = "v1")
////    public ResponseEntity delete(@PathVariable int id) {
////        departmentService.delete(id);
////        return new ResponseEntity(id);
////    }
////
////    @PutMapping("")
////    @ApiOperation(value = "Update Department", tags = "v1")
////    public ResponseEntity update(@RequestBody Department department) {
////        int count = departmentService.update(department);
////        return new ResponseEntity(count);
////    }
//}
