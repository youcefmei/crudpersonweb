CREATE TABLE person (
                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                        lastname VARCHAR(255) DEFAULT NULL,
                        firstname VARCHAR(255) DEFAULT NULL,
                        PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO person (id, lastname, firstname) VALUES
                                                 (1, 'Hyde', 'Jemima'),
                                                 (2, 'Thornton', 'Adele'),
                                                 (3, 'Ramirez', 'Shellie'),
                                                 (4, 'Pennington', 'Kelly'),
                                                 (5, 'Forbes', 'Bruno'),
                                                 (6, 'Britt', 'Quinn'),
                                                 (7, 'Glass', 'Jescie'),
                                                 (8, 'Booker', 'Thane'),
                                                 (9, 'Riddle', 'Lance'),
                                                 (10, 'Kline', 'Rylee'),
                                                 (11, 'Neal', 'Sonia'),
                                                 (12, 'Mitchell', 'Neil'),
                                                 (13, 'Saunders', 'Alexis'),
                                                 (14, 'Watkins', 'Branden'),
                                                 (15, 'Vaughan', 'Emi'),
                                                 (16, 'Hancock', 'Palmer'),
                                                 (17, 'Holloway', 'Isabella'),
                                                 (18, 'Cotton', 'Silas'),
                                                 (19, 'Wong', 'Ryder'),
                                                 (20, 'Cooper', 'Nero'),
                                                 (21, 'Delacruz', 'Tallulah'),
                                                 (22, 'Sullivan', 'Imelda'),
                                                 (23, 'Stewart', 'Orlando'),
                                                 (24, 'Drake', 'Thor'),
                                                 (25, 'Strickland', 'Adrienne');