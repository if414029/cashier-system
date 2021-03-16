DROP TABLE IF EXISTS customer;

CREATE TABLE customer(
     customer_id INT(11) PRIMARY KEY,
     customer_name VARCHAR(250) NOT NULL,
     gender VARCHAR(1) NOT NULL,
     phone_no VARCHAR(13) NOT NULL,
     address VARCHAR(250) NOT NULL
);


