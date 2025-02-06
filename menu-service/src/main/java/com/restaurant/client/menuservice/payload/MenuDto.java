package com.restaurant.client.menuservice.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.restaurant.client.menuservice.model.enums.MenuType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    @JsonIgnore
    @JsonSetter("menu_id")
    private Long menuId;
    @JsonSetter("type")
    private MenuType dietMenuType;
}
