package com.restaurant.client.menuservice.model;

import com.restaurant.client.menuservice.model.enums.MenuType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

import static com.restaurant.client.menuservice.model.constant.AllModelConstant.*;

@Getter
@Setter
@Entity
@Table(name = TABLE_MENU)
@NoArgsConstructor
public class MenuModel {
    @Id
    @Column(name = FIELD_MENU_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(name = FIELD_MENU_TYPE)
    private String dietMenuType;

    @OneToMany(mappedBy = TABLE_MENU, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<DishModel> dishes;

    @OneToMany(mappedBy = TABLE_MENU, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<DrinkModel> drinks;
}
