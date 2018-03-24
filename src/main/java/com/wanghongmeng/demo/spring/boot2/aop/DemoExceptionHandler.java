package com.wanghongmeng.demo.spring.boot2.aop;

import com.wanghongmeng.demo.spring.boot2.dto.ResponseEntity;
import com.wanghongmeng.demo.spring.boot2.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Slf4j
public class DemoExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity notFoundHandler(ResourceNotFoundException exception, ServletWebRequest request) {
        log.warn("{}", exception.toString());
        return new ResponseEntity(HttpStatus.NOT_FOUND.value(), "Not Found", exception.getClass().getCanonicalName(),
                "Resource Not Found", request.getRequest().getRequestURI());
    }
}