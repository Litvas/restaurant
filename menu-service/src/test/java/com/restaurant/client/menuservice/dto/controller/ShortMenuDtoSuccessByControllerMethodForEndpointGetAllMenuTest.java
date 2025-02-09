package com.restaurant.client.menuservice.dto.controller;

import com.restaurant.client.menuservice.dto.DataDtoFactoryTest;
import com.restaurant.client.menuservice.model.enums.MenuType;
import com.restaurant.client.menuservice.payload.ShortMenuDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("controller-method-getAllMenu")
public class ShortMenuDtoSuccessByControllerMethodForEndpointGetAllMenuTest implements DataDtoFactoryTest {

    @Override
    public List<ShortMenuDto> createListDataSuccess() {
        return List.of(
                new ShortMenuDto(1L, MenuType.TRADITIONAL_MENU.getType()),
                new ShortMenuDto(2L, MenuType.VEGETARIAN_MENU.getType()),
                new ShortMenuDto(3L, MenuType.VEGAN_MENU.getType())
        );
    }
}
