package com.restaurant.client.menuservice.controller;


import com.restaurant.client.menuservice.annotation.Loggable;
import com.restaurant.client.menuservice.payload.FullMenuDto;
import com.restaurant.client.menuservice.payload.ShortMenuDto;
import com.restaurant.client.menuservice.service.MenuService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.restaurant.client.menuservice.controller.constant.MenuControllerConstant.*;

@RestController
@AllArgsConstructor
@RequestMapping(API)
public class MenuController {
    private final MenuService menuService;

    @Loggable
    @SneakyThrows
    @GetMapping(GET_ALL_MENU)
    public ResponseEntity<List<ShortMenuDto>> getAllMenu() {
        return ResponseEntity.ok(menuService.getAllMenu());
    }

    @Loggable
    @SneakyThrows
    @GetMapping(GET_MENU_BY_ID)
    public ResponseEntity<FullMenuDto> getMenuById(@PathVariable Long menuId) {
        return ResponseEntity.ok(menuService.getMenuById(menuId));
    }

    @Loggable
    @SneakyThrows
    @GetMapping(GET_MENU_BY_TYPE)
    public ResponseEntity<FullMenuDto> getMenuByType(@RequestParam String type) {
        return ResponseEntity.ok(menuService.getMenuByType(type));
    }

}
