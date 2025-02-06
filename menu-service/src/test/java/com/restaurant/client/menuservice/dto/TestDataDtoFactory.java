package com.restaurant.client.menuservice.dto;

import com.restaurant.client.menuservice.model.enums.MenuType;
import com.restaurant.client.menuservice.payload.MenuDto;

import java.util.List;

public class TestDataDtoFactory {

    public static List<MenuDto> createMenuDtoGetAllSuccess() {
        return List.of(
                new MenuDto(1L, MenuType.TRADITIONAL_MENU),
                new MenuDto(2L, MenuType.VEGETARIAN_MENU),
                new MenuDto(3L, MenuType.VEGAN_MENU)
        );
    }

    public static MenuDto createMenuDtoSuccess() {
        MenuDto menuDto = new MenuDto();
        menuDto.setMenuId(1L);
        menuDto.setDietMenuType(MenuType.TRADITIONAL_MENU);
        return menuDto;
    }


}
