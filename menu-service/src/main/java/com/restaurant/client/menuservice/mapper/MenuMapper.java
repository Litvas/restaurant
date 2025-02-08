package com.restaurant.client.menuservice.mapper;

import com.restaurant.client.menuservice.model.MenuModel;
import com.restaurant.client.menuservice.payload.FullMenuDto;
import com.restaurant.client.menuservice.payload.ShortMenuDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MenuMapper {
    List<ShortMenuDto> shortMenuDtoList(List<MenuModel> menuModels);
    FullMenuDto fullMenuDto(MenuModel menuModels);
}
