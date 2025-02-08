package com.restaurant.client.menuservice.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortMenuDto {
    @JsonIgnore
    @JsonSetter("menu_id")
    private Long menuId;
    @JsonSetter("type")
    private String dietMenuType;


}
