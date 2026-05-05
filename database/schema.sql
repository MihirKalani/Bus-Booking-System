CREATE DATABASE IF NOT EXISTS bus_reservation;

USE bus_reservation;

CREATE TABLE IF NOT EXISTS bus (
    bus_id INT AUTO_INCREMENT PRIMARY KEY,
    bus_no VARCHAR(20) NOT NULL,
    departure DATETIME NOT NULL,
    seating_capacity INT NOT NULL,
    starting_point VARCHAR(50) NOT NULL,
    ending_point VARCHAR(50) NOT NULL,
    bus_available BOOLEAN DEFAULT TRUE
);

CREATE TABLE IF NOT EXISTS passenger (
    pass_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    date_booked DATETIME DEFAULT CURRENT_TIMESTAMP,
    amount DOUBLE NOT NULL,
    bus_id INT,
    source VARCHAR(50),
    dest VARCHAR(50),
    FOREIGN KEY (bus_id) REFERENCES bus(bus_id)
);
