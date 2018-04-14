//package com.wanghongmeng.demo.spring.boot2.service;
//
//import com.wanghongmeng.demo.spring.boot2.dao.DepartmentDao;
//import com.wanghongmeng.demo.spring.boot2.dto.ResponseEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.ServerRequest;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import reactor.core.publisher.Mono;
//
//@Component
//public class DepartmentHandler {
//
//    private DepartmentDao departmentDao;
//
//    @Autowired
//    public DepartmentHandler(DepartmentDao departmentDao) {
//        this.departmentDao = departmentDao;
//    }
//
//    public Mono<ServerResponse> get(ServerRequest serverRequest) {
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
//                .body(Mono.justOrEmpty(new ResponseEntity(departmentDao.get())), ResponseEntity.class);
//    }
//
////    public Department getById(int id) {
////        return departmentDao.getById(id);
////    }
//
//    public Mono<ServerResponse> add(ServerRequest request) {
////        Mono<Department> department = request.bodyToMono(Department.class);
////        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
////                .body(Mono.justOrEmpty(new ResponseEntity(departmentDao.add(department))), ResponseEntity.class);
//        return null;
//    }
//
////    public void delete(int id) {
////        departmentDao.delete(id);
////    }
////
////    public int update(Department department) {
////        return departmentDao.update(department);
////    }
//}
