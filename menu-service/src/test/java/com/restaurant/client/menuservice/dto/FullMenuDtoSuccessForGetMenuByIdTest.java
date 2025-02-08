package com.restaurant.client.menuservice.dto;

import com.restaurant.client.menuservice.dto.factory.DataDtoFactoryTest;
import com.restaurant.client.menuservice.model.enums.DishType;
import com.restaurant.client.menuservice.model.enums.DrinkType;
import com.restaurant.client.menuservice.model.enums.MenuType;
import com.restaurant.client.menuservice.payload.FullMenuDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component("getMenuById")
public class FullMenuDtoSuccessForGetMenuByIdTest implements DataDtoFactoryTest {

    @Override
    public FullMenuDto  createDataSuccess() {
        return FullMenuDto.builder()
                .menuId(1L)
                .dietMenuType(MenuType.TRADITIONAL_MENU.getType())
                .dishes(createDishes())
                .drinks(createDrinks())
                .build();
    }

    private  Set<FullMenuDto.Dish> createDishes() {
        return Set.of(
                FullMenuDto.Dish.builder()
                        .dishId(1L)
                        .dishName("dishName")
                        .dishType(DishType.DESSERT_DISH_TYPE.getType())
                        .picture("/relative-path/dish.img")
                        .ingredients(createDishIngredients())
                        .build()
        );
    }

    private  Set<FullMenuDto.Drink> createDrinks() {
        return Set.of(
                FullMenuDto.Drink.builder()
                        .drinkId(1L)
                        .drinkName("drinkName")
                        .drinkName(DrinkType.ALCOHOL_DRINK.getType())
                        .picture("/relative-path/drink.img")
                        .ingredients(createDrinkIngredients())
                        .build()
        );
    }

    private  List<FullMenuDto.Dish.Ingredient> createDishIngredients() {
        return List.of(
                FullMenuDto.Dish.Ingredient.builder()
                        .ingredientId(1L)
                        .ingredientName("someDishName")
                        .picture("/relative-path/dish/ingredient.img")
                        .build()
        );
    }

    private  List<FullMenuDto.Drink.Ingredient> createDrinkIngredients() {
        return List.of(
                FullMenuDto.Drink.Ingredient.builder()
                        .ingredientId(2L)
                        .ingredientName("someDrinkName")
                        .picture("/relative-path/drink/ingredient.img")
                        .build()
        );
    }
}
