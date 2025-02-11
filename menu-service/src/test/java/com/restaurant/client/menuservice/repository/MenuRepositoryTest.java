package com.restaurant.client.menuservice.repository;

import com.restaurant.client.menuservice.model.DishModel;
import com.restaurant.client.menuservice.model.DrinkModel;
import com.restaurant.client.menuservice.model.IngredientModel;
import com.restaurant.client.menuservice.model.MenuModel;
import com.restaurant.client.menuservice.model.enums.DishType;
import com.restaurant.client.menuservice.model.enums.DrinkType;
import com.restaurant.client.menuservice.model.enums.MenuType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @BeforeEach
    public void setUp() {
        IngredientModel ingredientModelDish = new IngredientModel();
        ingredientModelDish.setIngredientId(1L);
        ingredientModelDish.setIngredientName("IngredientDish");
        ingredientModelDish.setPicture("/ingredients_for/dish.jpg");

        IngredientModel ingredientModelDrink = new IngredientModel();
        ingredientModelDrink.setIngredientId(2L);
        ingredientModelDrink.setIngredientName("IngredientDrink");
        ingredientModelDrink.setPicture("/ingredients_for/drink.jpg");

        DishModel dishModel = new DishModel();
        dishModel.setDishId(1L);
        dishModel.setDishName("Dish");
        dishModel.setDishType(DishType.MAIN_DISH_TYPE.getType());
        dishModel.setPicture("./dish.jpg");
        dishModel.setIngredients(List.of(ingredientModelDish));

        DrinkModel drinkModel = new DrinkModel();
        drinkModel.setDrinkId(1L);
        drinkModel.setDrinkName("Drink");
        drinkModel.setDrinkType(DrinkType.SOFT_DRINK.getType());
        drinkModel.setIngredients(List.of(ingredientModelDrink));

        MenuModel menuModel = new MenuModel();
        menuModel.setMenuId(1L);
        menuModel.setDietMenuType(MenuType.VEGETARIAN_MENU.getType());
        menuModel.setDishes(Set.of(dishModel));
        menuModel.setDrinks(Set.of(drinkModel));
    }

    @Test
    public void whenFindMenuModelByMenuId_thenReturnOptionalMenuModel() {
        Long menuId = 1L;
        Optional<MenuModel> found = menuRepository.findMenuModelByMenuId(menuId);

        assertThat(found).isPresent();
        assertThat(found.get().getMenuId()).isEqualTo(menuId);
    }

    @Test
    public void whenFindMenuModelByMenuId_thenReturnEmpty() {
        Long menuId = 4L;
        Optional<MenuModel> foundOptional = menuRepository.findMenuModelByMenuId(menuId);

        assertThat(foundOptional).isEmpty();
    }

    @Test
    public void whenFindMenuModelByDietMenuType_thenReturnOptionalMenuModel() {
        String menuType = MenuType.VEGETARIAN_MENU.getType();
        Optional<MenuModel> found = menuRepository.findMenuModelByDietMenuType(menuType);

        assertThat(found).isPresent();
        assertThat(found.get().getDietMenuType()).isEqualTo(menuType);
    }

    @Test
    public void whenFindMenuModelByDietMenuType_thenReturnEmpty() {
        String menuType = "fault_type";
        Optional<MenuModel> foundOptional = menuRepository.findMenuModelByDietMenuType(menuType);

        assertThat(foundOptional).isEmpty();
    }
}
