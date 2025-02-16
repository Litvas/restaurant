package com.restaurant.client.menuservice.dto.service;

import com.restaurant.client.menuservice.dto.DataDtoFactoryTest;
import com.restaurant.client.menuservice.model.enums.DishType;
import com.restaurant.client.menuservice.model.enums.DrinkType;
import com.restaurant.client.menuservice.model.enums.MenuType;
import com.restaurant.client.menuservice.payload.FullMenuDto;
import com.restaurant.client.menuservice.payload.ShortMenuDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component("service-method-getAllMenu")
public class FullMenuDtoSuccessByServiceMethodForEndpointGetAllMenuTest implements DataDtoFactoryTest {

    @Override
    public List<ShortMenuDto> createListDataSuccess() {
        return List.of(
                new ShortMenuDto(1L, MenuType.TRADITIONAL_MENU.getType()),
                new ShortMenuDto(2L, MenuType.VEGETARIAN_MENU.getType()),
                new ShortMenuDto(3L, MenuType.VEGAN_MENU.getType())
        );
    }
}
