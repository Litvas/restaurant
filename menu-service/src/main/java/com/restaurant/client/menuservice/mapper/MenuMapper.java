package com.restaurant.client.menuservice.mapper;

import com.restaurant.client.menuservice.model.MenuModel;
import com.restaurant.client.menuservice.payload.MenuDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MenuMapper {
    List<MenuDto> menuDtoList(List<MenuModel> menuModels);
    MenuDto menuDto(MenuModel menuModels);
}
