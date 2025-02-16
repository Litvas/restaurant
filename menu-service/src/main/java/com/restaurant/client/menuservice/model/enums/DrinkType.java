package com.restaurant.client.menuservice.model.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum DrinkType {
    SOFT_DRINK("soft"),
    ALCOHOL_DRINK("alcohol");

    private final String type;
}
