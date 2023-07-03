INSERT INTO cliente VALUES (2, 90909090, "Maria", "Olguin", "2006-01-06", "Merlo", "SL"),
(3, 32131254, "Hernesto", "Lopez", "1988-01-06", "Tilisarao", "SL"),
(4, 34564395, "Ricardo", "Ford", "1598-01-06", "SL", "SL"),
(5, 66666654, "Juana", "Becerra", "1998-01-04", "SL", "BS AS"),
(6, 11111122, "Carla", "Becerra", "1958-01-06", "SL", "SL"),
(7, 89898989, "Maria", "Becerra", "1998-03-06", "SL", "Neuquen"),
(8, 67676777, "Griselda", "Lopez", "1987-05-03", "Naschel", "SL"),
(9, 99966667, "Demian", "de la vega", "1995-01-06", "Tilisarao", "SL");

INSERT INTO plan VALUES (2, "10mb", 2000.0, 0, "Internet"),
(3, "20mb", 5000.0, 10, "Internet + Cable"),
(4, "30mb", 10000.0, 30, "Internet + Cable HD"),
(5, "50mb", 20000.0, 50, "Internet fibra optica"),
(6, "1gb", 25000.0, 50, "Internet fibra optica + Cable");

INSERT INTO cliente_has_plan VALUES (2,2), (2,3);
INSERT INTO cliente_has_plan VALUES (3,4), (3,6);
INSERT INTO cliente_has_plan VALUES (9,2), (9,5);
INSERT INTO cliente_has_plan VALUES (9,3), (7,2);
INSERT INTO cliente_has_plan VALUES (8,2), (6,2);