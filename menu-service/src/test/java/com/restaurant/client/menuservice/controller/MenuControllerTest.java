package com.restaurant.client.menuservice.controller;

import com.restaurant.client.menuservice.dto.TestDataDtoFactory;
import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.service.MenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MenuService menuService;

    @Test
    void getAllMenuSuccess() throws Exception {
        when(menuService.getAllMenu()).thenReturn(TestDataDtoFactory.createMenuDtoGetAllSuccess());

        mockMvc.perform(get("/api/menus"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].type").value("TRADITIONAL_MENU"))
                .andExpect(jsonPath("$[1].type").value("VEGETARIAN_MENU"))
                .andExpect(jsonPath("$[2].type").value("VEGAN_MENU"));
    }

    @Test
    void getAllMenuFailure() throws Exception {
        when(menuService.getAllMenu()).thenThrow(new MenuNotFoundException(0));

        mockMvc.perform(get("/api/menus"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value("Total menu: 0, any menu not ready yet"));
    }

    @Test
    void getMenuByIdSuccess() throws Exception {
        when(menuService.getMenuById(1L)).thenReturn(TestDataDtoFactory.createMenuDtoSuccess());

        mockMvc.perform(get("/api/menu/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("TRADITIONAL_MENU"));
    }


    @Test
    void getMenuByIdFailure() throws Exception {
        when(menuService.getMenuById(1L)).thenThrow(new MenuNotFoundException("Menu not fount by this id: 2"));

        mockMvc.perform(get("/api/menu/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value("Menu not fount by this id: 2"));
    }

}
