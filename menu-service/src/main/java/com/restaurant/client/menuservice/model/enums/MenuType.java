package com.restaurant.client.menuservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MenuType {
    VEGAN_MENU("vegan"),
    VEGETARIAN_MENU("vegetarian"),
    TRADITIONAL_MENU("traditional");

    public final String type;
}
