//package com.wanghongmeng.demo.spring.boot2;
//
//import com.wanghongmeng.demo.spring.boot2.service.DepartmentHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.reactive.function.server.ServerResponse;
//
//@Component
//public class ApplicationRouter {
//
//    private DepartmentHandler departmentHandler;
//
//    @Autowired
//    public ApplicationRouter(DepartmentHandler departmentHandler) {
//        this.departmentHandler = departmentHandler;
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> departmentHandler() {
//        return RouterFunctions.route(RequestPredicates.GET("/v1/departments"), departmentHandler::get)
//                    .andRoute(RequestPredicates.POST("/v1/departments").and(RequestPredicates.contentType(MediaType.APPLICATION_JSON_UTF8)),
//                            departmentHandler::add);
//    }
//}
