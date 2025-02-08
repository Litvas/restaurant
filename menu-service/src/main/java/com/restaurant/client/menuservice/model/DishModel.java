package com.restaurant.client.menuservice.model;

import com.restaurant.client.menuservice.model.enums.DishType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

import static com.restaurant.client.menuservice.model.constant.AllModelConstant.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_DISH, uniqueConstraints = {
        @UniqueConstraint(columnNames = FIELD_DISH_NAME)
})
public class DishModel {
    @Id
    @Column(name = FIELD_DISH_ID)
    private Long dishId;

    @NotBlank
    @Size(max = 255)
    @Column(name = FIELD_DISH_NAME)
    private String dishName;

    @NotBlank
    @Size(max = 255)
    private String picture;

    @NotBlank
    @Column(name = FIELD_DISH_TYPE)
    private String dishType;

    @ManyToOne
    @JoinColumn(name = FIELD_MENU_ID)
    private MenuModel menu;

    @ManyToMany(mappedBy = MAPPED_BY_DISHES, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<IngredientModel> ingredients;

}
