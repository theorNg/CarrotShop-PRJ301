INSERT INTO Users  VALUES
(N'Jung', N'Kim', 'user@gmail.com', 'view/assets/home/img/users/user.jpg','admin', '12345', N'Ha Noi', '0981347469', 2, 0),
(N'admin', N'', 'admin@gmail.com', 'view/assets/home/img/users/user.jpg', 'admin1', '12345', N'Ha Noi', '0981347469', 1, 1),
(N'P', N'Thành', 'thanh@gmail.com', 'view/assets/home/img/users/1.jpg','phuuthanh2003', '12345', N'Ha Noi', '0707064154', 1, 1),
(N'Bé', N'Moon', 'Moon123@gmail.com', 'view/assets/home/img/users/user1.jpg','user2', '12345', N'Ha Noi', '06868686868', 2, 1),
(N'User', N'3', 'user3@gmail.com', 'view/assets/home/img/users/user3.jpg','user3', '12345', N'Ha Noi', '06868686868', 2, 1)

INSERT INTO Types VALUES
(N'Vegetables'),
(N'Fruits'),
(N'Healthy Bakery');

INSERT INTO Categories VALUES
(N'Domestic Vegetables',1),
(N'Imported Vegetables',1),
(N'Domestic Fruits',2),
(N'Imported Fruits',2),
(N'Cookies',3),
(N'Nuts',3);



INSERT INTO Suppliers VALUES
('TrangTrai2F', 'view/assets/home/img/suppliers/1.jpg'),
('TamAnFood', 'view/assets/home/img/suppliers/2.jpg'),
('SauXanh', 'view/assets/home/img/suppliers/3.jpg'),
('ThucPhamSach', 'view/assets/home/img/suppliers/4.jpg'),
('GreenGiant', 'view/assets/home/img/suppliers/5.jpg'),
('HFarm', 'view/assets/home/img/suppliers/6.jpg');


INSERT INTO Products (productname, supplierid, categoryid, size, stock, description, images, colors, releasedate, discount, unitSold, price, status, typeid)
VALUES
('Broccoli', 1, 1, 'G,Kg', 00, 'Fresh green broccoli, rich in vitamins', 'view/assets/home/img/products/1-1.jpeg view/assets/home/img/products/1-2.jpeg', 'Green', '2023-01-01', 0.10, 20, 150000, 'True', 1),
('Broccoli Rabe', 1, 2, 'G,Kg', 45, 'Leafy broccoli rabe, slightly bitter', 'view/assets/home/img/products/2-1.jpg view/assets/home/img/products/2-2.jpeg', 'Green', '2023-01-01', 0.10, 18, 160000, 'True', 1),
('Kale', 2, 2, 'G,Kg', 30, 'Organic kale leaves, perfect for salads', 'view/assets/home/img/products/3-1.jpg view/assets/home/img/products/3-2.jpg', 'Green', '2023-01-02', 0.05, 15, 120000, 'True', 1),
('Spinach', 2, 2, 'G,Kg', 55, 'Fresh spinach, rich in iron and vitamins', 'view/assets/home/img/products/4-1.jpeg view/assets/home/img/products/4-2.jpeg', 'Green', '2023-01-03', 0.12, 30, 100000, 'True', 1),
('Swiss Chard', 3, 2, 'G,Kg', 40, 'Colorful Swiss chard, nutrient-packed', 'view/assets/home/img/products/5-1.jpeg view/assets/home/img/products/5-2.jpeg', 'Green, Red', '2023-01-04', 0.08, 22, 130000, 'True', 1),
('Artichoke', 3, 2, 'G,Kg', 20, 'Fresh artichokes, ideal for healthy diets', 'view/assets/home/img/products/6-1.jpg view/assets/home/img/products/6-2.jpeg', 'Green', '2023-01-05', 0.15, 25, 300000, 'True', 1),
('Watercress', 4, 2, 'G,Kg', 35, 'Crispy watercress, peppery flavor', 'view/assets/home/img/products/7-1.jpg view/assets/home/img/products/7-2.jpg', 'Green', '2023-01-06', 0.11, 20, 110000, 'True', 1),
('Celery', 4, 2, 'G,Kg', 45, 'Crisp celery stalks, fresh from the farm', 'view/assets/home/img/products/8-1.jpeg view/assets/home/img/products/8-2.jpg', 'Green', '2023-01-07', 0.05, 30, 200000, 'True', 1),
('Spring Onion', 5, 1, 'G,Kg', 50, 'Aromatic spring onions, versatile use', 'view/assets/home/img/products/9-1.png view/assets/home/img/products/9-2.jpeg', 'Green', '2023-01-08', 0.07, 35, 90000, 'True', 1),
('Microgreens', 5, 2, 'G,Kg', 20, 'Nutrient-rich microgreens, small but mighty', 'view/assets/home/img/products/10-1.jpeg view/assets/home/img/products/10-2.jpeg', 'Green', '2023-01-09', 0.20, 10, 250000, 'True', 1);

INSERT INTO Products (productname, supplierid, categoryid, size, stock, description, images, colors, releasedate, discount, unitSold, price, status, typeid)
VALUES
('Red Onion', 1, 2, 'G,Kg', 50, 'Fresh and vibrant red onions, perfect for enhancing flavor', 'view/assets/home/img/products/11-1.jpeg view/assets/home/img/products/11-2.jpeg', 'Red', '2023-01-11', 0.05, 40, 90000, 'True', 1),
('Shallots', 1, 1, 'G,Kg', 45, 'Small, delicate shallots, ideal for gourmet dishes', 'view/assets/home/img/products/12-1.jpeg view/assets/home/img/products/12-2.jpeg', 'Purple', '2023-01-11', 0.05, 35, 110000, 'True', 1),
('Potatoes', 1, 2, 'G,Kg', 60, 'Versatile and hearty potatoes, a staple for any kitchen', 'view/assets/home/img/products/13-1.jpeg view/assets/home/img/products/13-2.jpeg', 'Yellow', '2023-01-12', 0.03, 50, 80000, 'True', 1),
('Sweet Potatoes', 1, 2, 'G,Kg', 40, 'Nutritious and sweet, perfect for roasting or baking', 'view/assets/home/img/products/14-1.jpeg view/assets/home/img/products/14-2.jpeg', 'Purple', '2023-01-13', 0.08, 30, 120000, 'True', 1),
('Ginger', 1, 2, 'G,Kg', 30, 'Fresh and aromatic ginger, essential for Asian cuisine', 'view/assets/home/img/products/15-1.jpeg view/assets/home/img/products/15-2.jpg', 'Brown', '2023-01-15', 0.10, 30, 150000, 'True', 1),
('Beets', 1, 1, 'G,Kg', 45, 'Rich and earthy beets, full of antioxidants', 'view/assets/home/img/products/16-1.jpeg view/assets/home/img/products/16-2.jpeg', 'Red', '2023-01-16', 0.06, 35, 100000, 'True', 1),
('Garlic', 1, 1, 'G,Kg', 50, 'Powerful and essential garlic, a must-have for flavoring', 'view/assets/home/img/products/17-1.jpg view/assets/home/img/products/17-2.jpeg', 'White', '2023-01-17', 0.04, 40, 70000, 'True', 1),
('Daikon Radish', 1, 1, 'G,Kg', 30, 'Mild and crunchy daikon radish, perfect for salads', 'view/assets/home/img/products/18-1.jpeg view/assets/home/img/products/18-2.jpeg', 'White', '2023-01-18', 0.05, 30, 85000, 'True', 1),
('Parsley', 1, 1, 'G,Kg', 25, 'Fresh and aromatic parsley, great for garnishing', 'view/assets/home/img/products/19-1.jpg view/assets/home/img/products/19-2.jpeg', 'Green', '2023-01-19', 0.10, 25, 50000, 'True', 1),
('Carrots', 1, 1, 'G,Kg', 55, 'Crunchy and sweet carrots, rich in beta-carotene', 'view/assets/home/img/products/20-1.jpeg view/assets/home/img/products/20-2.jpeg', 'Orange', '2023-01-20', 0.05, 45, 60000, 'True', 1);

INSERT INTO products (productname, supplierid, categoryid, size, stock, description, images, colors, releasedate, discount, unitSold, price, status, typeid)
VALUES
('Apples', 3, 3, 'G,Kg', 60, 'Juicy and sweet apples, perfect for a healthy snack', 'view/assets/home/img/products/21-1.jpg view/assets/home/img/products/21-2.jpg', 'Red', '2023-01-21', 0.05, 50, 120000, 'True', 2),
('Red Grapes VietNam', 3, 3, 'G,Kg', 55, 'Fresh and sweet red grapes, ideal for fresh consumption or wine', 'view/assets/home/img/products/22-1.jpg view/assets/home/img/products/22-2.jpg', 'Red', '2023-01-22', 0.05, 45, 140000, 'True', 2),
('Red Grapes', 4, 4, 'G,Kg', 55, 'Fresh and sweet red grapes, ideal for fresh consumption or wine', 'view/assets/home/img/products/23-1.jpg view/assets/home/img/products/23-2.jpg', 'Red', '2023-01-22', 0.05, 45, 140000, 'True', 2),
('White Grapes', 4, 4, 'G,Kg', 50, 'Crisp and juicy white grapes, a delightful treat', 'view/assets/home/img/products/24-1.jpg view/assets/home/img/products/24-2.jpg', 'Green', '2023-01-22', 0.05, 40, 135000, 'True', 2),
('Kiwi', 5, 4, 'G,Kg', 30, 'Bright and tangy kiwi, full of vitamins', 'view/assets/home/img/products/25-1.jpg view/assets/home/img/products/25-2.jpg', 'Green', '2023-01-25', 0.10, 30, 220000, 'True', 2),
('Green Kiwi', 5, 4, 'G,Kg', 35, 'Sweet and sour green kiwi, rich in Vitamin C', 'view/assets/home/img/products/26-1.jpg view/assets/home/img/products/26-2.jpg', 'Green', '2023-01-25', 0.10, 25, 210000, 'True', 2),
('Pears', 6, 4, 'G,Kg', 50, 'Soft and sweet pears, juicy and delicious', 'view/assets/home/img/products/27-1.jpg ', 'Yellow', '2023-01-26', 0.06, 30, 110000, 'True', 2),
('Limes', 6, 3, 'G,Kg', 45, 'Zesty limes, perfect for adding a tangy twist to dishes', 'view/assets/home/img/products/28-1.jpg ', 'Green', '2023-01-28', 0.07, 40, 90000, 'True', 2),
('Dragon Fruit', 2, 3, 'G,Kg', 20, 'Vibrant and nutritious dragon fruit, packed with fiber', 'view/assets/home/img/products/29-1.jpg ', 'Pink, White', '2023-01-29', 0.15, 15, 300000, 'True', 2),
('Mangosteen', 2, 3, 'G,Kg', 25, 'Exotic and juicy mangosteen, known as the queen of fruits', 'view/assets/home/img/products/30-1.jpg', 'Purple', '2023-01-30', 0.20, 20, 350000, 'True', 2);



INSERT INTO Payments VALUES 
(N'Cash'),
(N'Credit Card');

select * from [dbo].[Users]

INSERT INTO [Orders] VALUES 
('2022-06-10 12:30:00', 1192.00, 1, 'user2', 0),
('2018-07-20 11:19:00', 4396.00, 1, 'phuuthanh2003', 1),
('2019-01-19 11:30:00', 2100.00, 1, 'user2', 1),
('2024-01-19 11:30:00', 2200.00, 1, 'user2', 1),
('2020-09-10 12:30:00', 2685.00, 1, 'phuuthanh2003', 0),
('2021-03-10 12:30:00', 500.00, 1, 'user2', 1),
('2024-04-20 11:19:00', 824.00, 1, 'user2', 1),
('2022-07-20 11:19:00', 1040.00, 1, 'user2', 1),
('2024-09-10 12:30:00', 650.00, 1, 'user2', 1),
('2019-12-19 11:30:00', 1399.00, 1, 'user2', 1),
('2022-11-10 12:10:16', 500.00, 1, 'user2', 1),
('2019-02-14 12:30:00', 875.00, 1, 'admin1', 1);

select * from [dbo].[Orders]

INSERT INTO OrderItem VALUES 
(2, 1100.0, 11, 7),
(3, 345.0, 19, 8),
(3, 550.0, 20, 8),
(5, 650.0, 23, 9),
(1, 500.0, 22, 10),
(2, 412.0, 22, 11),
(1, 2200.0, 14, 12),
(1, 875.0, 6, 13),
(1, 315.0, 5, 13),
(1, 1040.0, 20, 14),
(2, 1500.0, 20, 15),
(1, 650.0, 21, 16),
(1, 425.0, 22, 17),
(1, 1399.0, 23, 18),
(1, 1290.0, 29, 19),
(1, 700.0, 26, 20);
