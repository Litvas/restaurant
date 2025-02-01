package com.restaurant.client.menuservice.model;

import com.restaurant.client.menuservice.model.constant.AllModelConstant;
import com.restaurant.client.menuservice.model.enums.DishType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import static com.restaurant.client.menuservice.model.constant.AllModelConstant.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = DISH_TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(columnNames = DISH_NAME)
})
public class DishModel {
    @Id
    @Column(name = DISH_ID)
    private Long dishId;

    @NotBlank
    @Size(max = 255)
    @Column(name = DISH_NAME)
    private String dishName;

    @NotBlank
    @Size(max = 255)
    private String picture;

    @NotBlank
    @Column(name = DISH_TYPE)
    private DishType dishType;

    @ManyToOne
    @JoinColumn(name = MENU_ID)
    private MenuModel menu;



}
