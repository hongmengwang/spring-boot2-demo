package com.wanghongmeng.demo.spring.boot2.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class Employee {
    @ApiModelProperty(value = "Primary Key")
    private int id;
    @ApiModelProperty(value = "Employee Name")
    private String name;
    @ApiModelProperty(value = "Employee's Department ID")
    private int departmentId;
    @ApiModelProperty(value = "Association Department")
    private Department department;
    @ApiModelProperty(value = "Employee Number")
    private String employeeNo;
    @ApiModelProperty(value = "Created Datetime")
    private Date createdAt;
    @ApiModelProperty(value = "Created User")
    private String createdBy;
    @ApiModelProperty(value = "Updated Datetime")
    private Date updatedAt;
    @ApiModelProperty(value = "Updated User")
    private String updatedBy;
}
