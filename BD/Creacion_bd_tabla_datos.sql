CREATE DATABASE bd_stefanini;

USE bd_stefanini;

CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidoP VARCHAR(100) NOT NULL,
    apellidoM VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);


INSERT INTO usuario (nombre, apellidoP, apellidoM, email) VALUES ('Ana', 'Lopez','Perez','ana.lopez@example.com');
INSERT INTO usuario (nombre, apellidoP, apellidoM, email) VALUES ('Juan', 'Gonzalez','Ramirez', 'juan.gonzalez@example.com');
INSERT INTO usuario (nombre, apellidoP, apellidoM, email) VALUES ('Diego', 'Martinez','Baez','diego.martinez@example.com');
INSERT INTO usuario (nombre, apellidoP, apellidoM, email) VALUES ('Laura', 'Hernandez','Rodriguez', 'laura.hernandez@example.com');


select * from Usuario;