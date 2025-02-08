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
    Set<Dish> dishes;
    Set<Drink> drinks;

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Dish {
        @JsonIgnore
        @JsonSetter("dish_id")
        Long dishId;

        @JsonSetter("name")
        String dishName;
        String picture;

        @JsonSetter("type")
        String dishType;
        List<Ingredient> ingredients;

        @Data
        @Builder
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Ingredient {
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
    public static class Drink {
        @JsonIgnore
        @JsonSetter("drink_id")
        Long drinkId;

        @JsonSetter("name")
        String drinkName;
        String picture;

        @JsonSetter("type")
        String type;
        List<Ingredient> ingredients;

        @Data
        @Builder
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Ingredient {
            @JsonIgnore
            @JsonSetter("ingredient_id")
            Long ingredientId;

            @JsonSetter("name")
            String ingredientName;
            String picture;
        }
    }

}
