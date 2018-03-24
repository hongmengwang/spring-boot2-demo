package com.wanghongmeng.demo.spring.boot2.resource;

import com.wanghongmeng.demo.spring.boot2.controller.EmployeeController;
import com.wanghongmeng.demo.spring.boot2.entity.Employee;
import com.wanghongmeng.demo.spring.boot2.exception.ResourceNotFoundException;
import lombok.Getter;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.DummyInvocationUtils;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

@Getter
public class EmployeeResource extends ResourceSupport {
    private Employee employee;

    public EmployeeResource(Employee employee) {
        this.employee = employee;
        if (null == employee) {
            throw new ResourceNotFoundException("Employee Not Found");
        }

        int id = employee.getId();
        this.add(ControllerLinkBuilder.linkTo(EmployeeController.class).withRel("employee"));
        this.add(ControllerLinkBuilder.linkTo(DummyInvocationUtils.methodOn(EmployeeController.class).getById(id)).withSelfRel());
        this.add(ControllerLinkBuilder.linkTo(DummyInvocationUtils.methodOn(EmployeeController.class).getDepartments(id)).withRel("department"));
    }
}