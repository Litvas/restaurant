CREATE TABLE ingredient (
    ingredient_id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    picture VARCHAR(255) NOT NULL
);
