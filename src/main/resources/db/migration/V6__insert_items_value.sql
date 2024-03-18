INSERT INTO items (
  id,
  item_name,
  item_price,
  item_quantity,
  item_description,
  category_item_id, 
  author_item_id, -- Including the author_item_id column
  item_status,
  item_image_url,
  item_created,
  item_updated
)
VALUES
  (1,'Aspirin', 10, 100, 'A pain reliever and fever reducer.', 1, 1, 'Available', 'defaultItem.png', NOW(), NOW()),
  (2,'Blood Pressure Monitor', 50, 20, 'A device used to measure blood pressure.', 3, 1, 'Available', 'defaultItem.png', NOW(), NOW()),
  (3,'Bandage', 5, 200, 'A sterile dressing used to cover a wound.', 6, 1, 'Available', 'defaultItem.png', NOW(), NOW()),
  (4,'Thermometer', 7, 50, 'A device used to measure body temperature.', 1, 1, 'Available', 'defaultItem.png', NOW(), NOW()),
  (5,'Insulin Pen', 100, 10, 'A device used to inject insulin.', 2, 1, 'Available', 'defaultItem.png', NOW(), NOW()),
  (6,'Shower Chair', 30, 5, 'A chair designed for use in the shower.', 4, 1, 'Available', 'defaultItem.png', NOW(), NOW()),
  (7,'Crutches', 25, 15, 'A device used to help people walk.', 4, 1, 'Available', 'defaultItem.png', NOW(), NOW());
