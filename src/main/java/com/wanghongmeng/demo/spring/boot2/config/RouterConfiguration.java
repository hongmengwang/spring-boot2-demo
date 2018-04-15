//package com.wanghongmeng.demo.spring.boot2.config;
//
//import com.wanghongmeng.demo.spring.boot2.handler.DepartmentHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.server.reactive.HttpHandler;
//import org.springframework.http.server.reactive.TomcatHttpHandlerAdapter;
//import org.springframework.web.reactive.function.server.RequestPredicates;
//import org.springframework.web.reactive.function.server.RouterFunction;
//import org.springframework.web.reactive.function.server.RouterFunctions;
//import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
//
///**
// * Created by wanghongmeng on 2018/4/15.
// */
//@Configuration
//public class RouterConfiguration {
//    private DepartmentHandler departmentHandler;
//
//    @Autowired
//    public RouterConfiguration(DepartmentHandler departmentHandler) {
//        this.departmentHandler = departmentHandler;
//    }
//
//    @Bean
//    public RouterFunction<?> routerFunction() {
//        return RouterFunctions.route(RequestPredicates.GET("/v1/departments"), departmentHandler::get)
//                .andRoute(RequestPredicates.POST("/v1/departments"), departmentHandler::add)
//                .andRoute(RequestPredicates.PUT("/v1/departments"), departmentHandler::update)
//                .andRoute(RequestPredicates.GET("/v1/departments/{id}"), departmentHandler::getById)
//                .andRoute(RequestPredicates.DELETE("/v1/departments/{id}"), departmentHandler::delete);
//    }
//
//    @Bean
//    public ServletRegistrationBean<TomcatHttpHandlerAdapter> servletRegistrationBean() {
//        HttpHandler httpHandler = WebHttpHandlerBuilder.webHandler(RouterFunctions.toWebHandler(routerFunction())).build();
//        ServletRegistrationBean<TomcatHttpHandlerAdapter> registrationBean
//                = new ServletRegistrationBean<>(new TomcatHttpHandlerAdapter(httpHandler), "/");
//        registrationBean.setLoadOnStartup(1);
//        registrationBean.setAsyncSupported(true);
//
//        return registrationBean;
//    }
//}
