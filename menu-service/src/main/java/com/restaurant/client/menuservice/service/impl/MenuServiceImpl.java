package com.restaurant.client.menuservice.service.impl;

import com.restaurant.client.menuservice.exception.MenuNotFoundException;
import com.restaurant.client.menuservice.mapper.MenuMapper;
import com.restaurant.client.menuservice.model.MenuModel;
import com.restaurant.client.menuservice.payload.FullMenuDto;
import com.restaurant.client.menuservice.payload.ShortMenuDto;
import com.restaurant.client.menuservice.repository.MenuRepository;
import com.restaurant.client.menuservice.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public List<ShortMenuDto> getAllMenu() throws MenuNotFoundException{
        List<ShortMenuDto> menuDto = menuMapper.shortMenuDtoList(menuRepository.findAll());
        if (menuDto.isEmpty()) {
            throw new MenuNotFoundException(0);
        }
        return menuDto;
    }

    @Override
    public FullMenuDto getMenuById(Long id) throws MenuNotFoundException{
        Optional<MenuModel> optionalMenuModel = menuRepository.findMenuModelByMenuId(id);
        if (optionalMenuModel.isEmpty()) {
            throw new MenuNotFoundException(String.format("Menu id: '%s' is not found", id));
        }
        return menuMapper.fullMenuDto(optionalMenuModel.get());
    }

    @Override
    public FullMenuDto getMenuByType(String type) throws MenuNotFoundException {
        Optional<MenuModel> optionalMenuModel = menuRepository.findMenuModelByDietMenuType(type);
        if (optionalMenuModel.isEmpty()) {
            throw new MenuNotFoundException(String.format("Menu type: '%s' is not found", type));
        }
        return menuMapper.fullMenuDto(optionalMenuModel.get());
    }
}
