package com.wanghongmeng.demo.spring.boot2.controller.test;

import com.wanghongmeng.demo.spring.boot2.BaseTest;
import com.wanghongmeng.demo.spring.boot2.controller.EmployeeController;
import com.wanghongmeng.demo.spring.boot2.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@DisplayName("Test EmployeeController")
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest extends BaseTest {

    @MockBean
    private EmployeeService employeeService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get All Employees")
    void testGet() throws Exception {
        BDDMockito.given(employeeService.get()).willReturn(Collections.singletonList(employee));
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/employees").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Get Employee By Id")
    void testGetById() throws Exception {
        int id = 1;
        BDDMockito.given(employeeService.getById(id)).willReturn(employee);
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/employees/" + id).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Add Employee")
    void testAdd() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/v1/employees").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(jsonMapper.writeValueAsString(employee)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
