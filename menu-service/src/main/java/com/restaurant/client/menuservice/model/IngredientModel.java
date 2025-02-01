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
@Table(name = INGREDIENT_TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = INGREDIENT_NAME)
})
public class IngredientModel {
    @Id
    @Column(name = INGREDIENT_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ingredientId;

    @NotBlank
    @Size(max = 255)
    @Column(name = INGREDIENT_NAME)
    private String ingredientName;

    @NotBlank
    @Size(max = 255)
    private String picture;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = DISH_NAME,
            joinColumns = @JoinColumn(name = INGREDIENT_ID),
            inverseJoinColumns = @JoinColumn(name = DISH_ID)
    )
    private Set<DishModel> dishes;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(
            name = DRINK_NAME,
            joinColumns = @JoinColumn(name = INGREDIENT_ID),
            inverseJoinColumns = @JoinColumn(name = DRINK_NAME)
    )
    private Set<DrinkModel> drinks;
}
