package com.restaurant.client.menuservice.model.constant;

public class AllModelConstant {

    // Menu
    public static final String TABLE_MENU = "menu";
    public static final String FIELD_MENU_ID = "menu_id";
    public static final String FIELD_MENU_TYPE = "type";

    // Dish
    public static final String TABLE_DISH = "dish";
    public static final String FIELD_DISH_ID = "dish_id";
    public static final String FIELD_DISH_NAME = "name";
    public static final String FIELD_DISH_TYPE = "type";

    // Drink
    public static final String TABLE_DRINK = "drink";
    public static final String FIELD_DRINK_ID = "drink_id";
    public static final String FIELD_DRINK_NAME = "name";
    public static final String FIELD_DRINK_TYPE = "type";

    // Drink
    public static final String TABLE_INGREDIENT= "ingredient";
    public static final String FIELD_INGREDIENT_ID = "ingredient_id";
    public static final String FIELD_INGREDIENT_NAME = "name";

    // Relationships
    public static final String TABLE_DISH_INGREDIENT = "dish_ingredient";
    public static final String TABLE_DRINK_INGREDIENT = "drink_ingredient";

    // Many-to-Many mappedBy
    public static final String MAPPED_BY_DISHES = "dishes";
    public static final String MAPPED_BY_DRINKS = "drinks";

}
