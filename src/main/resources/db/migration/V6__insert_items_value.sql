-- V8__insert_items_value.sql
INSERT INTO items (
  item_name,
  item_price,
  item_quantity,
  item_description,
  category_item_id,
  author_item_id,
  item_status,
  item_image_url,
  item_created,
  item_updated
)
VALUES
  ('Aspirin', 10, 100, 'A pain reliever and fever reducer.', 1,1, 'Available', 'defaultItem.png', NOW(), NOW()),
  ('Blood Pressure Monitor', 50, 20, 'A device used to measure blood pressure.', 3,1,  'Available', 'defaultItem.png', NOW(), NOW()),
  ('Bandage', 5, 200, 'A sterile dressing used to cover a wound.', 6,1, 'Available', 'defaultItem.png', NOW(), NOW()),
  ('Thermometer', 7, 50, 'A device used to measure body temperature.', 1,1, 'Available', 'defaultItem.png', NOW(), NOW()),
  ('Insulin Pen', 100, 10, 'A device used to inject insulin.', 2, 1,  'Available', 'defaultItem.png', NOW(), NOW()),
  ('Shower Chair', 30, 5, 'A chair designed for use in the shower.', 4, 1,  'Available', 'defaultItem.png', NOW(), NOW()),
  ('Crutches', 25, 15, 'A device used to help people walk.', 4, 1, 'Available', 'defaultItem.png', NOW(), NOW());
