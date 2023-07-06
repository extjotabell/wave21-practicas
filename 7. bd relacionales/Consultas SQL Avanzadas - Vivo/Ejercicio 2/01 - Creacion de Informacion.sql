use biblioteca;

-- Inserción de Libros
INSERT INTO `Libros` (`idLibro`, `Titulo`, `Editorial`, `Area`) VALUES
(1, 'El gran Gatsby', 'Editorial A', 'Ficción'),
(2, 'Cien años de soledad', 'Editorial B', 'Literatura'),
(3, 'Inteligencia artificial', 'Editorial C', 'Tecnología'),
(4, 'El principito', 'Editorial D', 'Infantil'),
(5, 'Historia del tiempo', 'Editorial E', 'Ciencia');

-- Inserción de Autores
INSERT INTO `Autores` (`idAutor`, `Nombre`, `Nacionalidad`) VALUES
(1, 'F. Scott Fitzgerald', 'Estados Unidos'),
(2, 'Gabriel García Márquez', 'Colombia'),
(3, 'John McCarthy', 'Estados Unidos'),
(4, 'Antoine de Saint-Exupéry', 'Francia'),
(5, 'Stephen Hawking', 'Reino Unido');


-- Inserción de LibroAutor
INSERT INTO `LibroAutores` (`idLibro`, `idAutor`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Inserción de Estudiantes
INSERT INTO `Estudiantes` (`idLector`, `Nombre`, `Apellido`, `Direccion`, `Carrera`, `Edad`) VALUES
(1, 'Juan', 'Pérez', 'Calle Principal 123', 'Informática', 20),
(2, 'María', 'Gómez', 'Avenida Central 456', 'Administración', 22),
(3, 'Luis', 'Rodríguez', 'Plaza Mayor 789', 'Contabilidad', 21),
(4, 'Ana', 'Sánchez', 'Boulevard Secundario 321', 'Arquitectura', 23),
(5, 'Pedro', 'López', 'Carrera Principal 654', 'Derecho', 24);

-- Inserción de Prestamos
INSERT INTO `Prestamos` (`FechaPrestamo`, `FechaDevolucion`, `Devuelto`, `Prestamocol`, `idLector`, `idLibro`) VALUES
('2023-06-27 10:00:00', '2023-07-04 10:00:00', 1, 'Préstamo 1', 1, 1),
('2023-06-28 11:00:00', '2023-07-05 11:00:00', 0, 'Préstamo 2', 2, 2),
('2023-06-29 12:00:00', '2023-07-06 12:00:00', 0, 'Préstamo 3', 3, 3),
('2023-06-30 13:00:00', '2023-07-07 13:00:00', 1, 'Préstamo 4', 4, 4),
('2023-07-01 14:00:00', '2023-07-08 14:00:00', 0, 'Préstamo 5', 5, 5);
