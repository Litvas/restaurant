package com.restaurant.client.menuservice.model;

import com.restaurant.client.menuservice.model.enums.MenuType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static com.restaurant.client.menuservice.model.constant.AllModelConstant.*;

@Getter
@Setter
@Entity
@Table(name = MENU_TABLE_NAME)
@NoArgsConstructor
public class MenuModel {
    @Id
    @Column(name = MENU_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(name = MENU_TYPE)
    @Enumerated(EnumType.STRING)
    private MenuType dietMenuType;

    @OneToMany(mappedBy = MENU_TABLE_NAME, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<DishModel> dishes;

    @OneToMany(mappedBy = MENU_TABLE_NAME, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<DrinkModel> drinks;
}
