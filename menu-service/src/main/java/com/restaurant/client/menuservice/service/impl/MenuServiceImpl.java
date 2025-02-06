package com.restaurant.client.menuservice.service.impl;

import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.mapper.MenuMapper;
import com.restaurant.client.menuservice.model.MenuModel;
import com.restaurant.client.menuservice.payload.MenuDto;
import com.restaurant.client.menuservice.repository.MenuRepository;
import com.restaurant.client.menuservice.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public List<MenuDto> getAllMenu() throws MenuNotFoundException{
        List<MenuDto> menuDto = menuMapper.menuDtoList(menuRepository.findAll());
        if (menuDto.isEmpty()) {
            throw new MenuNotFoundException(0);
        }
        return menuDto;
    }

    @Override
    public MenuDto getMenuById(Long id) throws MenuNotFoundException{
        Optional<MenuModel> optionalMenuModel = menuRepository.findMenuModelByMenuId(id);
        if (optionalMenuModel.isEmpty()) {
            throw new MenuNotFoundException(String.format("Menu id: %S is not found", id));
        }
        return menuMapper.menuDto(optionalMenuModel.get());
    }
}
