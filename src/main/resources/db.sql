-- Drop tables if they already exist
DROP TABLE IF EXISTS portfolio;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS stocks;
DROP TABLE IF EXISTS users;

-- Create users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    balance DECIMAL(10, 2) DEFAULT 0.00
);

-- Create stocks table
CREATE TABLE stocks (
    id SERIAL PRIMARY KEY,
    symbol VARCHAR(10) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    last_updated TIMESTAMP
);

-- Create orders table
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    stock_id BIGINT REFERENCES stocks(id),
    quantity INTEGER NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    type VARCHAR(4) NOT NULL,  -- 'Buy' or 'Sell'
    order_date TIMESTAMP NOT NULL
);

-- Create portfolio table
CREATE TABLE portfolio (
    id SERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    stock_id BIGINT REFERENCES stocks(id),
    quantity INTEGER NOT NULL
);

-- Insert sample data into users table
INSERT INTO users (username, password, email, balance)
VALUES
('john_doe', 'password123', 'john.doe@example.com', 10000.00),
('jane_smith', 'securePass', 'jane.smith@example.com', 5000.00),
('michael_scott', 'dunderMifflin', 'michael.scott@example.com', 7500.00);

-- Insert sample data into stocks table
INSERT INTO stocks (symbol, name, price, last_updated)
VALUES
('AAPL', 'Apple Inc.', 150.50, NOW()),
('GOOGL', 'Alphabet Inc.', 2800.75, NOW()),
('TSLA', 'Tesla Inc.', 1000.25, NOW());

-- Insert sample data into orders table
INSERT INTO orders (user_id, stock_id, quantity, price, type, order_date)
VALUES
(1, 1, 10, 150.50, 'Buy', NOW()),  -- John Doe buys 10 Apple stocks
(2, 3, 5, 1000.25, 'Buy', NOW()),  -- Jane Smith buys 5 Tesla stocks
(3, 2, 2, 2800.75, 'Buy', NOW());  -- Michael Scott buys 2 Alphabet stocks

-- Insert sample data into portfolio table
INSERT INTO portfolio (user_id, stock_id, quantity)
VALUES
(1, 1, 10),  -- John Doe holds 10 Apple stocks
(2, 3, 5),   -- Jane Smith holds 5 Tesla stocks
(3, 2, 2);   -- Michael Scott holds 2 Alphabet stocks
