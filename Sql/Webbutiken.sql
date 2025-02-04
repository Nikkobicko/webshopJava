
DROP DATABASE IF EXISTS webshop;
CREATE DATABASE webshop;
USE webshop;

#delete from productcategory where product_id > 4;
#delete from product where product_id > 4;
#delete from category where category_id >5;
#ALTER TABLE category MODIFY category_id INT auto_increment primary key;
#ALTER TABLE category ADD CONSTRAINT  PRIMARY KEY (category_id);

CREATE TABLE customer
(
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  first_name  VARCHAR(50) ,
  last_name   VARCHAR(50) ,
  email      VARCHAR(50) ,
  phone      VARCHAR(50) ,
  address    VARCHAR(50) ,
  postal_code VARCHAR(50) ,
  city       VARCHAR(50)

    );
/*ALTER TABLE customerDTO
    ADD FOREIGN KEY (password) REFERENCES password (customerDTO);*/
/*ALTER TABLE customerDTO
    drop foreign key customer_ibfk_1;*/
/*ALTER TABLE password
    ADD FOREIGN KEY (id) REFERENCES customerDTO (password);*/
/*ALTER TABLE customerDTO
    ADD  password INT;*/
# ALTER TABLE Customer DROP COLUMN password;
CREATE TABLE password
(
   id INT AUTO_INCREMENT PRIMARY KEY,
   password VARCHAR(50),
   customer int,
       FOREIGN KEY (customer) REFERENCES customer (customer_id)

);
#drop table password;

CREATE TABLE product
(
  product_id           INT AUTO_INCREMENT PRIMARY KEY,
  product_name         VARCHAR(50) ,
  description  VARCHAR(500),
  image_url     VARCHAR(500),
  price        DOUBLE        ,
  units_in_stock INT
);

CREATE TABLE orders
(
  order_id           INT AUTO_INCREMENT PRIMARY KEY,
  customer_id INT,
  datum  VARCHAR(500),
 FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

CREATE TABLE orderproduct
(
  order_id   INT,
  product_id INT,
  quantity  INT,
  PRIMARY KEY (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES orders (order_id),
  FOREIGN KEY (product_id) REFERENCES product (product_id)
);

CREATE TABLE category
(
  category_id   INT AUTO_INCREMENT PRIMARY KEY,
  category_name VARCHAR(50)
);

CREATE TABLE productcategory
(
  product_id  INT,
  category_id INT,
  PRIMARY KEY (product_id, category_id),
  FOREIGN KEY (product_id) REFERENCES product (product_id),
  FOREIGN KEY (category_id) REFERENCES category (category_id)
);

--

-- Create Custumer values
INSERT INTO customer VALUES (customer_id, 'Sven', 'Svenson', 'sven@svenson.se', '3426442', 'Streatgatan, 24', '17125', 'Stockholm');
INSERT INTO customer VALUES (customer_id, 'Thor', 'Odinson', 'thor@odinson.se',  '2345245', 'Upsalagatan, 14', '24342', 'Uppsala');
INSERT INTO customer VALUES (customer_id, 'Ivan', 'Petrov', 'ivan@petrov.se',  '5543452', 'Moscowgatan, 100', '434343', 'Moscow');

#INSERT into password values ( id, 'qq6',  4);
-- Create Product values
INSERT INTO product VALUES (product_id, 'Skinny Jeans', '5-pocket low-rise jeans in washed stretch denim with a button fly and skinny legs.',
                            'prod1.jpg',
                            330, 250);
INSERT INTO product VALUES (product_id, 'Cargojoggers',
                            'Ett par cargojoggers i stretchig bomullstwill. De har resår med dragsko i midjan. Sidfickor och myntficka. Bakfickor och benfickor med lock och tryckknappar. Formande sömmar på knäna och mudd vid benslut. Fuskgylf',
                            'hmgoepprod.jpg',
                            200, 1000);
INSERT INTO product VALUES (product_id, 'Chelsea boots', 'Chelsea boots with elastic gores in the sides, cotton canvas linings and insoles and rubber soles. Heel 2.5 cm.',
                            'prod2shoe.jpg',
                            100, 500);
INSERT INTO product VALUES (product_id, 'Watch with a leather strap', 'PREMIUM QUALITY. Stainless steel watch with an adjustable leather strap with a metal fastener. Width of strap approx. 2 cm, total length 23 cm, diameter of watch face 3.6 cm.',
                            'prod3watch.jpg',
                            400, 200);

-- Create Category values

INSERT INTO category VALUES (category_id, 'Jeans');
INSERT INTO category VALUES (category_id, 'Non jeans pants');
INSERT INTO category VALUES (category_id, 'All pants');

INSERT INTO category VALUES (category_id, 'Shoes');
INSERT INTO category VALUES (category_id, 'Watches');

-- Create ProductCategory
INSERT INTO productcategory VALUES (1, 1);
INSERT INTO productcategory VALUES (1, 3);
INSERT INTO productcategory VALUES (2, 2);
INSERT INTO productcategory VALUES (2, 3);
INSERT INTO productcategory  VALUES (3, 4);
INSERT INTO productcategory  VALUES (4, 5);

-- Create Order values
INSERT INTO orders VALUES (order_id, 1, '2017-02-08 17:23:17');

-- Create OrderProduct values

INSERT INTO orderproduct VALUES (1, 1,  2);
INSERT INTO orderproduct VALUES (1, 2,  1);
INSERT INTO orderproduct VALUES (1, 3,  4);

INSERT INTO product VALUES (product_id, 'Overshirt green linen', 'Overshirt in 100% linen. Classic shirt jacket for men with pockets on the chest and buttoning at the front..',
                            '652255_l.jpg',
                            330, 250);
INSERT INTO product VALUES (product_id, 'TOTEME SIGNATURE COTTON SHIRT WHITE', 'White shirt in crisp cotton quality from Totême. Signature Cotton Shirt has a boxy fit and an oversized silhouette. The shirt features a classic collar and Totême''s characteristic monogram subtly embroidered',
                            'toteme-signature-cotton-shirt-white.jpeg',
                            330, 250);
INSERT INTO product VALUES (product_id, 'Stylish sneakers, anthracite', 'Stylish sneakers.',
                            'shoe2.jpg',
                            330, 250);


INSERT INTO category VALUES (17, 'Shirt');


INSERT INTO productcategory VALUES (7, 4);
INSERT INTO productcategory VALUES (5, 17);
INSERT INTO productcategory VALUES (6, 17);

