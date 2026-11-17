-- Esquema de la Feria del Libro: Stands, Editorial y Reservacion
CREATE DATABASE IF NOT EXISTS ferialibro CHARACTER SET utf8mb4;
USE ferialibro;

DROP TABLE IF EXISTS reservacion;
DROP TABLE IF EXISTS stand;
DROP TABLE IF EXISTS editorial;

CREATE TABLE editorial (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    nombre      VARCHAR(100) NOT NULL,
    pais        VARCHAR(60)  NOT NULL,
    email       VARCHAR(120)
);

CREATE TABLE stand (
    id          INT AUTO_INCREMENT PRIMARY KEY,
    numero      VARCHAR(10)  NOT NULL UNIQUE,
    ubicacion   VARCHAR(80)  NOT NULL,
    tamano_m2   DECIMAL(6,2) NOT NULL,
    precio      DECIMAL(10,2) NOT NULL
);

CREATE TABLE reservacion (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    stand_id        INT NOT NULL,
    editorial_id    INT NOT NULL,
    fecha_reserva   DATE NOT NULL,
    estado          VARCHAR(20) NOT NULL DEFAULT 'PENDIENTE',
    CONSTRAINT fk_res_stand     FOREIGN KEY (stand_id)     REFERENCES stand(id),
    CONSTRAINT fk_res_editorial FOREIGN KEY (editorial_id) REFERENCES editorial(id)
);

INSERT INTO editorial (nombre, pais, email) VALUES
 ('Editorial Planeta',   'España',  'contacto@planeta.example'),
 ('Fondo de Cultura Económica', 'México', 'info@fce.example'),
 ('Penguin Random House','Estados Unidos', 'ventas@prh.example'),
 ('Ediciones Siruela',   'España',  'hola@siruela.example');

INSERT INTO stand (numero, ubicacion, tamano_m2, precio) VALUES
 ('A-01', 'Pasillo Central',  12.00, 15000.00),
 ('A-02', 'Pasillo Central',   9.00, 11000.00),
 ('B-01', 'Entrada Norte',    16.00, 20000.00),
 ('B-02', 'Entrada Norte',     6.00,  7500.00),
 ('C-01', 'Zona Infantil',     8.00,  9000.00);

INSERT INTO reservacion (stand_id, editorial_id, fecha_reserva, estado) VALUES
 (1, 1, '2026-10-01', 'CONFIRMADA'),
 (3, 2, '2026-10-05', 'CONFIRMADA'),
 (2, 3, '2026-10-12', 'PENDIENTE'),
 (5, 4, '2026-10-15', 'CANCELADA');
