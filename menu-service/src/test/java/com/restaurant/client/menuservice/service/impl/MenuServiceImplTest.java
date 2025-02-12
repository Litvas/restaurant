package com.restaurant.client.menuservice.service.impl;

import com.restaurant.client.menuservice.dto.DataDtoFactoryTest;
import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.mapper.MenuMapper;
import com.restaurant.client.menuservice.model.MenuModel;
import com.restaurant.client.menuservice.payload.FullMenuDto;
import com.restaurant.client.menuservice.payload.ShortMenuDto;
import com.restaurant.client.menuservice.repository.MenuRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class MenuServiceImplTest {
    @Mock
    private MenuRepository menuRepository;

    @Mock
    private MenuMapper menuMapper;

    @Mock
    private MenuModel menuModel;

    @InjectMocks
    private MenuServiceImpl menuService;

    @Autowired
    @Qualifier("service-method-getAllMenu")
    private DataDtoFactoryTest beanGetAllMenu;

    @Autowired
    @Qualifier("service-method-getMenuById")
    private DataDtoFactoryTest beanGetMenuById;

    @Autowired
    @Qualifier("service-method-getMenuByType")
    private DataDtoFactoryTest beanGetMenuByType;

    private static Long defaultId;
    private static String traditionalType;
    private static String vegetarianType;
    private static String veganType;
    private static String dessertType;
    private static String failureType;


    @BeforeAll
    public static void initData() {
        veganType = "vegan";
        vegetarianType = "vegetarian";
        traditionalType = "traditional";
        failureType = "failureType";
        defaultId = 1L;
        dessertType = "dessert";
    }


    @Test
    void shouldGiveAllMenuSuccess() throws MenuNotFoundException {
        when(
                menuMapper.shortMenuDtoList((menuRepository.findAll())))
                .thenReturn(beanGetAllMenu.createListDataSuccess());

        List<ShortMenuDto> result =  menuService.getAllMenu();

        assertNotNull(result);
        assertEquals(traditionalType, result.get(0).getDietMenuType());
        assertEquals(vegetarianType, result.get(1).getDietMenuType());
        assertEquals(veganType, result.get(2).getDietMenuType());
        verify(menuRepository, times(2)).findAll();
    }

    @Test
    void shouldGiveAllMenuFailure() {
        when(
                menuMapper.shortMenuDtoList((menuRepository.findAll())))
                .thenReturn(Collections.emptyList());

       Exception exception = assertThrows(MenuNotFoundException.class, () -> {
           menuService.getAllMenu();
       });
       assertEquals("Total menu: 0, any menu not ready yet", exception.getMessage());
    }

    @Test
    void shouldGiveByIdSuccess() throws MenuNotFoundException {
        when(menuRepository.findMenuModelByMenuId(defaultId)).thenReturn(Optional.of(menuModel));
        when(menuMapper.fullMenuDto(menuModel)).thenReturn(beanGetMenuById.createDataSuccess());

        FullMenuDto actualDto = menuService.getMenuById(defaultId);

        assertThat(actualDto).isNotNull();
        assertThat(actualDto).isEqualTo(beanGetMenuById.createDataSuccess());

        verify(menuRepository, times(1)).findMenuModelByMenuId(defaultId);
        verify(menuMapper, times(1)).fullMenuDto(menuModel);
    }

    @Test
    void shouldGiveByIdField() {
        String exceptionMessage = String.format("Menu id: '%s' is not found", defaultId);

        when(menuRepository.findMenuModelByMenuId(defaultId)).thenReturn(Optional.empty());
        when(menuMapper.fullMenuDto(menuModel))
                .thenReturn(null);

        Exception exception = assertThrows(MenuNotFoundException.class, () -> menuService.getMenuById(defaultId));
        assertEquals(exceptionMessage, exception.getMessage());
    }


    @Test
    void shouldGiveByTypeSuccess() throws MenuNotFoundException {
        when(menuRepository.findMenuModelByDietMenuType(traditionalType)).thenReturn(Optional.of(menuModel));
        when(menuMapper.fullMenuDto(menuModel)).thenReturn(beanGetMenuByType.createDataSuccess());

        FullMenuDto actualDto = menuService.getMenuByType(traditionalType);

        assertThat(actualDto).isNotNull();
        assertThat(actualDto).isEqualTo(beanGetMenuByType.createDataSuccess());

        verify(menuRepository, times(1)).findMenuModelByDietMenuType(traditionalType);
        verify(menuMapper, times(1)).fullMenuDto(menuModel);
    }

    @Test
    void shouldGiveByTypeField() {
        String exceptionMessage = String.format("Menu type: '%s' is not found", failureType);

        when(menuRepository.findMenuModelByDietMenuType(failureType)).thenReturn(Optional.empty());
        when(menuMapper.fullMenuDto(menuModel))
                .thenReturn(null);

        Exception exception = assertThrows(MenuNotFoundException.class, () -> menuService.getMenuByType(failureType));
        assertEquals(exceptionMessage, exception.getMessage());
    }



}
