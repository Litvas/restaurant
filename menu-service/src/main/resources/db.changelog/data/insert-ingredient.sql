INSERT INTO ingredient (ingredient_id, ingredient_name, picture) VALUES
    (1, 'Avocado', 'avocado.jpg'),
    (2, 'Tomato', 'tomato.jpg'),
    (3, 'Lettuce', 'lettuce.jpg'),
    (4, 'Potatoes', 'potatoes.jpg'),
    (5, 'Beef', 'beef.jpg'),
    (6, 'Almond Milk', 'almond_milk.jpg'),
    (7, 'Cucumber', 'cucumber.jpg'),
    (8, 'Lime', 'lime.jpg');

INSERT INTO dish_ingredient (dish_id, ingredient_id) VALUES
    (1, 1), -- Vegan Tacos -> Avocado
    (1, 2), -- Vegan Tacos -> Tomato
    (1, 3), -- Vegan Tacos -> Lettuce
    (2, 2), -- Vegetable Soup -> Tomato
    (2, 3), -- Vegetable Soup -> Lettuce
    (3, 4), -- Steak and Potatoes -> Potatoes
    (3, 5); -- Steak and Potatoes -> Beef

INSERT INTO drink_ingredient (drink_id, ingredient_id) VALUES
    (1, 6), -- Almond Milk Latte -> Almond Milk
    (3, 7), -- Green Mexican -> Cucumber
    (3, 8); -- Green Mexican -> Lime