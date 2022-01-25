-- CREATE DATABASE Webbutiken;
DROP DATABASE IF EXISTS Webshop;
CREATE DATABASE Webshop;
USE Webshop;

CREATE TABLE Customer
(
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name  VARCHAR(50) ,
  last_name   VARCHAR(50) ,
  email      VARCHAR(50) ,
  password VARCHAR(50) ,
  phone      VARCHAR(50) ,
  address    VARCHAR(50) ,
  postal_code VARCHAR(50) ,
  city       VARCHAR(50)
    );

CREATE TABLE Product
(
  product_id           INT AUTO_INCREMENT PRIMARY KEY,
  product_name         VARCHAR(50) ,
  description  VARCHAR(500),
  image_url     VARCHAR(500),
  price        DOUBLE        ,
  units_in_stock INT
);

CREATE TABLE Orders
(
  order_id           INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  datum  VARCHAR(500),
 FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

CREATE TABLE OrderProduct
(
  order_id   INT,
  product_id INT,
  quantity  INT,
  PRIMARY KEY (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES Orders (order_id),
  FOREIGN KEY (product_id) REFERENCES Product (product_id)
);

CREATE TABLE Category
(
  category_id   INT AUTO_INCREMENT PRIMARY KEY,
  category_name VARCHAR(50)
);

CREATE TABLE ProductCategory
(
  product_id  INT,
  category_id INT,
  PRIMARY KEY (product_id, category_id),
  FOREIGN KEY (product_id) REFERENCES Product (product_id),
  FOREIGN KEY (category_id) REFERENCES Category (category_id)
);

--

-- Create Custumer values
INSERT INTO Customer VALUES (customer_id, 'Sven', 'Svenson', 'sven@svenson.se', 'a123456', '3426442', 'Streatgatan, 24', '17125', 'Stockholm');
INSERT INTO Customer VALUES (customer_id, 'Thor', 'Odinson', 'thor@odinson.se', '123457', '2345245', 'Upsalagatan, 14', '24342', 'Uppsala');
INSERT INTO Customer VALUES (customer_id, 'Ivan', 'Petrov', 'ivan@petrov.se', '123458', '5543452', 'Moscowgatan, 100', '434343', 'Moscow');


-- Create Product values
INSERT INTO Product VALUES (product_id, 'Skinny Jeans', '5-pocket low-rise jeans in washed stretch denim with a button fly and skinny legs.',
                            'https://s3.eu-central-1.amazonaws.com/imagesnz/prod1.jpg',
                            330, 250);
INSERT INTO Product VALUES (product_id, 'Cargojoggers',
                            'Ett par cargojoggers i stretchig bomullstwill. De har resår med dragsko i midjan. Sidfickor och myntficka. Bakfickor och benfickor med lock och tryckknappar. Formande sömmar på knäna och mudd vid benslut. Fuskgylf',
                            'https://s3.eu-central-1.amazonaws.com/imagesnz/hmgoepprod.jpg',
                            200, 1000);
INSERT INTO Product VALUES (product_id, 'Chelsea boots', 'Chelsea boots with elastic gores in the sides, cotton canvas linings and insoles and rubber soles. Heel 2.5 cm.',
                            'https://s3.eu-central-1.amazonaws.com/imagesnz/prod2shoe.jpg',
                            100, 500);
INSERT INTO Product VALUES (product_id, 'Watch with a leather strap', 'PREMIUM QUALITY. Stainless steel watch with an adjustable leather strap with a metal fastener. Width of strap approx. 2 cm, total length 23 cm, diameter of watch face 3.6 cm.',
                            'https://s3.eu-central-1.amazonaws.com/imagesnz/prod3watch.jpg',
                            400, 200);

-- Create Category values
INSERT INTO Category VALUES (category_id, 'Jeans');
INSERT INTO Category VALUES (category_id, 'Byxor');
INSERT INTO Category VALUES (category_id, 'Shoes');
INSERT INTO Category VALUES (category_id, 'Watches');

-- Create ProductCategory
INSERT INTO ProductCategory VALUES (1, 1);
INSERT INTO ProductCategory VALUES (1, 2);
INSERT INTO ProductCategory VALUES (2, 2);
INSERT INTO ProductCategory  VALUES (3, 3);
INSERT INTO ProductCategory  VALUES (4, 4);

-- Create Order values
INSERT INTO Orders VALUES (order_id, 1, '2017-02-08 17:23:17');

-- Create OrderProduct values

INSERT INTO OrderProduct VALUES (1, 1,  2);
INSERT INTO OrderProduct VALUES (1, 2,  1);
INSERT INTO OrderProduct VALUES (1, 3,  4);
