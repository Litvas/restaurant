package com.restaurant.client.menuservice.controller;

import com.restaurant.client.menuservice.dto.DataDtoFactoryTest;
import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.service.MenuService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @Autowired
    @Qualifier("controller-method-getAllMenu")
    private DataDtoFactoryTest beanGetAllMenu;

    @Autowired
    @Qualifier("controller-method-getMenuById")
    private DataDtoFactoryTest beanGetMenuById;

    @Autowired
    @Qualifier("controller-method-getMenuByType")
    private DataDtoFactoryTest beanGetMenuByType;

    @MockitoBean
    private MenuService menuService;

    private static String traditionalType;
    private static String vegetarianType;
    private static String veganType;

    private static String endpointMenus;
    private static String endpointMenuById;
    private static String endpointMenuByType;
    private static String failureType;

    @BeforeAll
    public static void initData() {
        veganType = "vegan";
        vegetarianType = "vegetarian";
        traditionalType = "traditional";
        failureType = "failureType";

        endpointMenus = "/api/menus";
        endpointMenuById = "/api/menu_id/%s";
        endpointMenuByType = "/api/menu_type?type=%s";
    }

    @Test
    void getAllMenuSuccess() throws Exception {
        when(menuService.getAllMenu()).thenReturn(beanGetAllMenu.createListDataSuccess());

        mockMvc.perform(get(endpointMenus))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(3))
                .andExpect(jsonPath("$[0].type").value(traditionalType))
                .andExpect(jsonPath("$[1].type").value(vegetarianType))
                .andExpect(jsonPath("$[2].type").value(veganType));
    }

    @Test
    void getAllMenuFailure() throws Exception {
        when(menuService.getAllMenu()).thenThrow(new MenuNotFoundException(0));

        mockMvc.perform(get(endpointMenus))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value("Total menu: 0, any menu not ready yet"));
    }

    @Test
    void getMenuByIdSuccess() throws Exception {
        when(menuService.getMenuById(1L)).thenReturn(beanGetMenuById.createDataSuccess());

        mockMvc.perform(get(String.format(endpointMenuById, 1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value(traditionalType));
    }


    @Test
    void getMenuByIdFailure() throws Exception {
        when(menuService.getMenuById(1L)).thenThrow(new MenuNotFoundException("Menu not fount by this id: 2"));

        mockMvc.perform(get(String.format(endpointMenuById, 1)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value("Menu not fount by this id: 2"));
    }

    @Test
    void getMenuByTypeSuccess() throws Exception {
        when(menuService.getMenuByType(traditionalType)).thenReturn(beanGetMenuByType.createDataSuccess());

        mockMvc.perform(get(String.format
                        (endpointMenuByType, traditionalType)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value(traditionalType));
    }

    @Test
    void getMenuByTypeFailure() throws Exception {
        when(menuService.getMenuByType(failureType)).thenThrow(new MenuNotFoundException(String.format("Menu type: '%s' is not found", failureType)));

        mockMvc.perform(get(String.format(endpointMenuByType, failureType)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(HttpStatus.NOT_FOUND.value()))
                .andExpect(jsonPath("$.status").value(HttpStatus.NOT_FOUND.getReasonPhrase()))
                .andExpect(jsonPath("$.message").value(String.format("Menu type: '%s' is not found", failureType)));
    }

}
