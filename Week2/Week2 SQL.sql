CREATE DATABASE kluh7;
USE kluh7;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL
);

INSERT INTO products (name, description, price, quantity) VALUES
('Laptop', 'Dell XPS 13', 1200.00, 10),
('Smartphone', 'Samsung Galaxy S21', 999.00, 20),
('Tablet', 'Apple iPad Pro', 799.00, 15);

SELECT * FROM products
