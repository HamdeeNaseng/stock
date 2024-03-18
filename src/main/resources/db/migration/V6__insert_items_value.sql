-- V8__insert_items_value.sql
INSERT INTO items (
  id,
  item_name,
  item_price,
  item_quantity,
  item_description,
  category_i1
  item_image_url
)
VALUES
  (1,'Aspirin', 10, 100, 'A pain reliever and fever reducer.', 1, 1, 'Available', 'defaultItem.png'),
  (2,'Blood Pressure Monitor', 50, 20, 'A device used to measure blood pressure.', 3, 1, 'Available', 'defaultItem.png'),
  (3,'Bandage', 5, 200, 'A sterile dressing used to cover a wound.', 6, 1, 'Available', 'defaultItem.png'),
  (4,'Thermometer', 7, 50, 'A device used to measure body temperature.', 1, 1, 'Available', 'defaultItem.png'),
  (5,'Insulin Pen', 100, 10, 'A device used to inject insulin.', 2, 1, 'Available', 'defaultItem.png'),
  (6,'Shower Chair', 30, 5, 'A chair designed for use in the shower.', 4, 1, 'Available', 'defaultItem.png'),
  (7,'Crutches', 25, 15, 'A device used to help people walk.', 4, 1, 'Available', 'defaultItem.png');
