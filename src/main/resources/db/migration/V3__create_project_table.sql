CREATE TABLE Project(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    value decimal(10,2) DEFAULT 0,
    clientID int,
    techleadID int,
    completed BOOLEAN DEFAULT 0,
    FOREIGN KEY (clientID) REFERENCES Client(id),
    FOREIGN KEY(techleadID) REFERENCES Employee(id)
);

CREATE TABLE ProjectDelivery (
	id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
	projectID int,
    deliveryID int,
    onProject BOOLEAN DEFAULT 1,
    FOREIGN KEY (projectID) REFERENCES Project(ID),
    FOREIGN KEY (deliveryID) REFERENCES Employee(ID)
);