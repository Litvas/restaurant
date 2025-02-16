package com.restaurant.client.menuservice.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FullMenuDto {
    @JsonIgnore
    @JsonSetter("menu_id")
    Long menuId;
    @JsonSetter("type")
    String dietMenuType;
    Set<DishDto> dishes;
    Set<DrinkDto> drinks;

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class DishDto {
        @JsonIgnore
        @JsonSetter("dish_id")
        Long dishId;

        @JsonSetter("name")
        String dishName;
        String picture;

        @JsonSetter("type")
        String dishType;
        List<IngredientDto> ingredients;

        @Data
        @Builder
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class IngredientDto {
            @JsonIgnore
            @JsonSetter("ingredient_id")
            Long ingredientId;

            @JsonSetter("name")
            String ingredientName;
            String picture;
        }
    }

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class DrinkDto {
        @JsonIgnore
        @JsonSetter("drink_id")
        Long drinkId;

        @JsonSetter("name")
        String drinkName;
        String picture;

        @JsonSetter("type")
        String drinkType;
        List<IngredientDto> ingredients;

        @Data
        @Builder
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class IngredientDto {
            @JsonIgnore
            @JsonSetter("ingredient_id")
            Long ingredientId;

            @JsonSetter("name")
            String ingredientName;
            String picture;
        }
    }

}
