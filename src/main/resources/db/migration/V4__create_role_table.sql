CREATE TABLE `Role` (
    RoleID TINYINT NOT NULL,
    Name varchar(64) NOT NULL,
    PRIMARY KEY (RoleID)
);

INSERT INTO Role(RoleID, Name) VALUES (1, 'Admin');
INSERT INTO Role(RoleID, Name) VALUES (2, 'HR');
INSERT INTO Role(RoleID, Name) VALUES (3, 'Management');
INSERT INTO Role(RoleID, Name) VALUES (4, 'Sales');