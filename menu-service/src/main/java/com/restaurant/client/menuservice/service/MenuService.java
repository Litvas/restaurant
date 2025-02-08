package com.restaurant.client.menuservice.service;

import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.payload.FullMenuDto;
import com.restaurant.client.menuservice.payload.ShortMenuDto;

import java.util.List;

public interface MenuService {
    List<ShortMenuDto> getAllMenu() throws MenuNotFoundException;
    FullMenuDto getMenuById(Long id) throws MenuNotFoundException;
    FullMenuDto getMenuByType(String type) throws MenuNotFoundException;
}
