package com.restaurant.client.menuservice.dto;

import com.restaurant.client.menuservice.payload.FullMenuDto;
import com.restaurant.client.menuservice.payload.ShortMenuDto;

import java.util.List;

public interface DataDtoFactoryTest {
    default List<ShortMenuDto> createListDataSuccess(){return List.of();}
    default FullMenuDto createDataSuccess(){return null;}
}