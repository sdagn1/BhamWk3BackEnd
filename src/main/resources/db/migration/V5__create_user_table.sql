CREATE TABLE `User` (
    Username varchar(64) NOT NULL,
    Password varchar(64) NOT NULL,
    RoleID TINYINT NOT NULL,
    PRIMARY KEY (Username),
    FOREIGN KEY (RoleID) REFERENCES Role(RoleID)
);

INSERT INTO User VALUES ('admin', 'admin', 1);
INSERT INTO User VALUES ('hr', 'hr', 2);
INSERT INTO User VALUES ('manage', 'manage', 3);
INSERT INTO User VALUES ('sales', 'sales', 3);