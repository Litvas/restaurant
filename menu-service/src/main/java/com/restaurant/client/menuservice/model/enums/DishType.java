package com.restaurant.client.menuservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DishType {
    MAIN_DISH_TYPE("main"),
    SALAD_DISH_TYPE("salad"),
    DESSERT_DISH_TYPE("dessert"),
    SNACK_DISH_TYPE("snack");

    private final String type;
}
