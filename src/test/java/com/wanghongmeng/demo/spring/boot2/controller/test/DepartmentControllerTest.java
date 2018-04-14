package com.wanghongmeng.demo.spring.boot2.controller.test;

import com.wanghongmeng.demo.spring.boot2.BaseTest;
import com.wanghongmeng.demo.spring.boot2.controller.DepartmentController;
import com.wanghongmeng.demo.spring.boot2.service.DepartmentService;
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

@DisplayName("Test DepartmentController")
@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest extends BaseTest {

    @MockBean
    private DepartmentService departmentService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Get All Departments")
    void testGet() throws Exception {
        BDDMockito.given(departmentService.get()).willReturn(Collections.singletonList(department));
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/departments").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk());
        //        .andDo((handler) -> {
//            String content = handler.getResponse().getContentAsString();
//            System.out.println(content);
//        });
    }

    @Test
    @DisplayName("Get Department By Id")
    void testGetById() throws Exception {
        int id = 1;
        BDDMockito.given(departmentService.getById(id)).willReturn(department);
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/v1/departments/" + id).contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("Add Department")
    void testAdd() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/v1/departments").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                        .content(jsonMapper.writeValueAsString(department))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
