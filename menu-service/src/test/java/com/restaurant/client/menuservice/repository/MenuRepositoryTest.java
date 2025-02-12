package com.restaurant.client.menuservice.repository;

import com.restaurant.client.menuservice.model.DishModel;
import com.restaurant.client.menuservice.model.DrinkModel;
import com.restaurant.client.menuservice.model.IngredientModel;
import com.restaurant.client.menuservice.model.MenuModel;
import com.restaurant.client.menuservice.model.enums.DishType;
import com.restaurant.client.menuservice.model.enums.DrinkType;
import com.restaurant.client.menuservice.model.enums.MenuType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    /** Each test will be adding 1 number to field menuId **/
    private Long menuId;

    @BeforeEach
    public void saveEntity() {
        MenuModel menuModel = new MenuModel();
        menuModel.setDietMenuType(MenuType.VEGETARIAN_MENU.getType());
        menuModel.setDishes(Set.of());
        menuModel.setDrinks(Set.of());

        menuModel = menuRepository.save(menuModel);
        menuId = menuModel.getMenuId();
    }

    @AfterEach
    public void deleteEntity() {
        menuRepository.deleteById(menuId);
    }

    @Test
    @Order(1)
    public void whenFindMenuModelByMenuId_thenReturnOptionalMenuModel() {
        Optional<MenuModel> found = menuRepository.findMenuModelByMenuId(menuId);

        assertThat(found).isPresent();
        assertThat(found.get().getMenuId()).isEqualTo(menuId);
    }

    @Test
    @Order(2)
    public void whenFindMenuModelByMenuId_thenReturnEmpty() {
        Long menuId = 10000000000L;
        Optional<MenuModel> foundOptional = menuRepository.findMenuModelByMenuId(menuId);

        assertThat(foundOptional).isEmpty();
    }

    @Test
    @Order(3)
    public void whenFindMenuModelByDietMenuType_thenReturnOptionalMenuModel() {
        String menuType = MenuType.VEGETARIAN_MENU.getType();
        Optional<MenuModel> found = menuRepository.findMenuModelByDietMenuType(menuType);

        assertThat(found).isPresent();
        assertThat(found.get().getDietMenuType()).isEqualTo(menuType);
    }

    @Test
    @Order(4)
    public void whenFindMenuModelByDietMenuType_thenReturnEmpty() {
        String menuType = "fault_type";
        Optional<MenuModel> foundOptional = menuRepository.findMenuModelByDietMenuType(menuType);

        assertThat(foundOptional).isEmpty();
    }
}
