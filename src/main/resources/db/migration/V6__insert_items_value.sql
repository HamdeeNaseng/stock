-- V8__insert_items_value.sql
INSERT INTO items (
  id,
  item_name,
  item_price,
  item_quantity,
  item_description,
  category_item_id,
  author_item_id,
  item_status,
  item_image_url
)
VALUES
  (1,'Aspirin', 10, 100, 'A pain reliever and fever reducer.', 1, '17fe7272-0b43-42bd-b4d0-e936d7214e37', 'Available', 'defaultItem.png'),
  (2,'Blood Pressure Monitor', 50, 20, 'A device used to measure blood pressure.', 3, '1bef90ed-fcb3-4e41-b3c0-ae8b9b00bd6b', 'Available', 'defaultItem.png'),
  (3,'Bandage', 5, 200, 'A sterile dressing used to cover a wound.', 6, '61776fc4-e91e-4525-99c3-800a68372fe7', 'Available', 'defaultItem.png'),
  (4,'Thermometer', 7, 50, 'A device used to measure body temperature.', 1, 'f5d5fed4-f1ac-4761-a457-df0943ed99fc', 'Available', 'defaultItem.png'),
  (5,'Insulin Pen', 100, 10, 'A device used to inject insulin.', 2, '17fe7272-0b43-42bd-b4d0-e936d7214e37', 'Available', 'defaultItem.png'),
  (6,'Shower Chair', 30, 5, 'A chair designed for use in the shower.', 4, '1bef90ed-fcb3-4e41-b3c0-ae8b9b00bd6b', 'Available', 'defaultItem.png'),
  (7,'Crutches', 25, 15, 'A device used to help people walk.', 4, '61776fc4-e91e-4525-99c3-800a68372fe7', 'Available', 'defaultItem.png');
