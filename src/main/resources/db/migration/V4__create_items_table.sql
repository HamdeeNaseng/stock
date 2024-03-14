-- V4__create_items_table.sql
CREATE TABLE IF NOT EXISTS items (
    id SERIAL PRIMARY KEY,
    item_name VARCHAR(255),
    item_price INT,
    item_quantity INT,
    item_description TEXT,
    category_item_id INT REFERENCES category(id),
    author_item_id VARCHAR(36) REFERENCES users(id), -- Change the data type to UUID
    item_status VARCHAR(255),
    item_image_url VARCHAR(255),
    item_created TIMESTAMP,
    item_updated TIMESTAMP,
    CONSTRAINT fk_category_item FOREIGN KEY (category_item_id) REFERENCES category(id),
    CONSTRAINT fk_author_item FOREIGN KEY (author_item_id) REFERENCES users(id)
);
