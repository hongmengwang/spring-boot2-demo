package com.wanghongmeng.demo.spring.boot2.handler;

import com.wanghongmeng.demo.spring.boot2.dao.DepartmentDao;
import com.wanghongmeng.demo.spring.boot2.dto.ResponseEntity;
import com.wanghongmeng.demo.spring.boot2.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DepartmentHandler {

    private DepartmentDao departmentDao;

    @Autowired
    public DepartmentHandler(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public Mono<ServerResponse> get(ServerRequest serverRequest) {
        List<Department> departmentList = departmentDao.get();
        ResponseEntity responseEntity = new ResponseEntity(departmentList);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(responseEntity));
    }

    public Mono<ServerResponse> getById(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        Department department = departmentDao.getById(id);
        ResponseEntity responseEntity = new ResponseEntity(department);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(responseEntity));
    }

    public Mono<ServerResponse> add(ServerRequest serverRequest) {
        Mono<Department> departmentMono = serverRequest.bodyToMono(Department.class);
        ResponseEntity responseEntity = new ResponseEntity();

        return departmentMono.doOnNext(departmentDao::add)
                .then(ServerResponse.ok().body(BodyInserters.fromObject(responseEntity)));
    }

    public Mono<ServerResponse> delete(ServerRequest serverRequest) {
        int id = Integer.parseInt(serverRequest.pathVariable("id"));
        departmentDao.delete(id);
        ResponseEntity responseEntity = new ResponseEntity();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(responseEntity));
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        Mono<Department> departmentMono = serverRequest.bodyToMono(Department.class);
        ResponseEntity responseEntity = new ResponseEntity();

        return departmentMono.doOnNext(departmentDao::update)
                .then(ServerResponse.ok().body(BodyInserters.fromObject(responseEntity)));
    }
}
