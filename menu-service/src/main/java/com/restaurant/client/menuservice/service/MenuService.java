package com.restaurant.client.menuservice.service;

import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.payload.MenuDto;

import java.util.List;

public interface MenuService {
    List<MenuDto> getAllMenu() throws MenuNotFoundException;
    MenuDto getMenuById(Long id) throws MenuNotFoundException;
}
