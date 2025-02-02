CREATE TABLE drink_ingredient (
        drink_id BIGINT NOT NULL,
        ingredient_id BIGINT NOT NULL,
        PRIMARY KEY (drink_id, ingredient_id),
        FOREIGN KEY (drink_id) REFERENCES drink(drink_id) ON DELETE CASCADE,
        FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id) ON DELETE CASCADE
);