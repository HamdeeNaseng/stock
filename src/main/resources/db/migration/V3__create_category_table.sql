-- V3__create_users_table.sql
CREATE TABLE IF NOT EXISTS category (
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(255),
    Description VARCHAR(255)
);
