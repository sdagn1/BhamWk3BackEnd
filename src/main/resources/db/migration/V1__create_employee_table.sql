CREATE TABLE Employee(
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    salary decimal(10,2) NOT NULL,
    bank_acc varchar(8) NOT NULL UNIQUE,
    ni varchar(9) NOT NULL UNIQUE,
    type tinyint NOT NULL DEFAULT 1
);

CREATE TABLE SalesComm(
    id int PRIMARY KEY,
    commission_rate decimal(5,2) NOT NULL DEFAULT 0,
    FOREIGN KEY (id) REFERENCES Employee(id)
);

