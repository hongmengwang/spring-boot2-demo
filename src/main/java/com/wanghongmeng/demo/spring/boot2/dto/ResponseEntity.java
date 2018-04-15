package com.wanghongmeng.demo.spring.boot2.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class ResponseEntity {
    private Date timestamp = new Date();
    private int status;
    private String error;
    private String exception;
    private String message;
    private String path;
    private Object data;

    public ResponseEntity() {
        this.status = HttpStatus.OK.value();
        this.message = "success";
    }

    public ResponseEntity(Object data) {
        this.status = HttpStatus.OK.value();
        this.data = data;
        this.message = "success";
    }

    public ResponseEntity(int status, String error, String exception, String message, String path) {
        this.status = status;
        this.error = error;
        this.exception = exception;
        this.message = message;
        this.path = path;
    }
}
