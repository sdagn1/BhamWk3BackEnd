CREATE TABLE Client (
    id int AUTO_INCREMENT NOT NULL,
    name varchar(50) NOT NULL,
    salesID int,
    PRIMARY KEY (id),
    FOREIGN KEY (salesID) REFERENCES Employee(id)
);