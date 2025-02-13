package com.restaurant.client.menuservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

import static com.restaurant.client.menuservice.model.constant.AllModelConstant.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TABLE_INGREDIENT, uniqueConstraints = {
        @UniqueConstraint(columnNames = FIELD_INGREDIENT_NAME)
})
public class IngredientModel {
    @Id
    @Column(name = FIELD_INGREDIENT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    @NotBlank
    @Size(max = 255)
    @Column(name = FIELD_INGREDIENT_NAME)
    private String ingredientName;

    @NotBlank
    @Size(max = 255)
    private String picture;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = TABLE_DISH_INGREDIENT,
            joinColumns = @JoinColumn(name = FIELD_INGREDIENT_ID),
            inverseJoinColumns = @JoinColumn(name = FIELD_DISH_ID)
    )
    private Set<DishModel> dishes;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = TABLE_DRINK_INGREDIENT,
            joinColumns = @JoinColumn(name = FIELD_INGREDIENT_ID),
            inverseJoinColumns = @JoinColumn(name = FIELD_DRINK_ID)
    )
    private Set<DrinkModel> drinks;
}
