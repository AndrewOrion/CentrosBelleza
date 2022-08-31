drop database if exists centrosBelleza;
create database centrosBelleza  character set latin1 collate latin1_spanish_Ci;
USE centrosBelleza;

create table personas (
	ID int primary key auto_increment,
    nombre varchar(50),
    documento varchar(9),
    fechaNacimiento date,
    direccion varchar(50),
    localidad varchar(30),
    cp varchar (5),
    provinciaID varchar (3),
    email varchar (30),
    telefono varchar (9),
    comunicaciones varchar (30),
    fechaAlta date,
    IP varchar (20),
    activo boolean);

INSERT INTO personas (nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
				IP,activo) VALUES
	('Andres Pino Gallardo','30999999J','1981-03-03','C/ Molino,12', 'Luecna', '14900',
		'4','and@g.com', '957000000','Nose','2000-06-01','90','si');
		
INSERT INTO personas (nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
				IP,activo) VALUES
	('Belen H D','30998999J','1981-03-03','C/ Molino,12', 'Luecna', '14900',
		'4','and@g.com', '957000000','Nose','2000-06-01','90','si');	
		
/*Crear tabla Salones

create table salones (
	id int(9) primary key auto_increment,
    nombre varchar(20),
    direccion varchar(30),
    localidad varchar(20),
    cp varchar(5),
    provinciaID int,
    email varchar(30),
    telefono varchar(8),
    activo boolean);

INSERT INTO salones (id,nombre,direccion,localidad,cp,provinciaID,email,telefono, activo) VALUES
	 (100000000,'Ana Gómez','No tiene calle','Granada','14550',6,'ninguno@ninguno.com','95700000',true),
	 (200000000,'Marta Peña','si tiene calle','Almeria','19550',4,'ninguno13@ninguno.com','95600000',false);

*/

/*Crear tabla Provincias*/

create table provincias (
	id int(3) primary key,
    nombre varchar(50));

INSERT INTO provincias (id,nombre) VALUES
	 (1,'Álava'),
	 (2,'Albacete'),
	 (3,'Alicante'),
	 (4,'Almería'),
	 (5,'Asturias'),
	 (6,'Ávila'),
	 (7,'Badajoz'),
	 (8,'Barcelona'),
	 (9,'Burgos'),
	 (10,'Cáceres'),
	 (11,'Cádiz'),
	 (12,'Cantabria'),
	 (13,'Castellón'),
	 (14,'Ciudad Real'),
	 (15,'Córdoba'),
	 (16,'La Coruña'),
	 (17,'Cuenca'),
	 (18,'Gerona'),
	 (19,'Granada'),
	 (20,'Guadalajara'),
	 (21,'Guipúzcoa'),
	 (22,'Huelva'),
	 (23,'Huesca'),
	 (24,'Islas Baleares'),
	 (25,'Jaén'),
	 (26,'León'),
	 (27,'Lérida'),
	 (28,'Lugo'),
	 (29,'Madrid'),
	 (30,'Málaga'),
	 (31,'Murcia'),
	 (32,'Navarra'),
	 (33,'Orense'),
	 (34,'Palencia'),
	 (35,'Las Palmas'),
	 (36,'Pontevedra'),
	 (37,'La Rioja'),
	 (38,'Salamanca'),
	 (39,'Segovia'),
	 (40,'Sevilla'),
	 (41,'Soria'),
	 (42,'Tarragona'),
	 (43,'Santa Cruz de Tenerife'),
	 (44,'Teruel'),
	 (45,'Toledo'),
	 (46,'Valencia'),
	 (47,'Valladolid'),
	 (48,'Vizcaya'),
	 (49,'Zamora'),
	 (50,'Zaragoza');



/*Crear tabla Productos*/
/*
create table productos (
	id int(5) primary key auto_increment,
	nombre varchar(50),
	foto varchar(100),
	precio double,
	fechaAlta date,
	sku varchar(5),
	formato varchar(50),
	stock int(5),
	activo boolean);

INSERT INTO productos (id, nombre, foto, precio, fechaAlta, sku, formato, stock, activo) VALUES
	 (1,'Crema','Ruta foto 1', 1.20, '2022-08-22', 'no', 'maxi', 500, true),
	 (2,'Shampoo', 'Ruta foto 2', 0.50, '2022-08-24', 'no', 'normal', 200, false),
	 (3,'Mascarilla', 'Ruta foto 3', 2.50, '2022-08-18', 'no', 'pequeño', 100, true);

*/	 
	 
/*Crear tabla Servicios*/
	 
	 create table servicios (
	ID int primary key auto_increment,
    nombre varchar(50),
    foto varchar (100),
    precio double,
    puntos int,
    activo boolean);

INSERT INTO servicios (nombre, foto, precio, puntos, activo) VALUES
	('Masajes','Ruta foto 1','30','12',1);
INSERT INTO servicios (nombre, foto, precio, puntos, activo) VALUES
	('Domicilio','Ruta foto 2','60','14',1);
		
/*Tabla Categorias y tipoCategorias*/
create table tipoCategoria (
	ID int primary key auto_increment,
	nombre varchar(30)
);
INSERT INTO tipoCategoria (nombre) VALUES
	('Deluxe');
INSERT INTO tipoCategoria (nombre) VALUES
	('Gama media');
INSERT INTO tipoCategoria (nombre) VALUES
	('Gama baja');
INSERT INTO tipoCategoria (nombre) VALUES
	('Oferta');
	
create table categorias (
	ID int primary key auto_increment,
    nombre varchar(50),
    foto varchar(100),
    tipoCategoriaID int,
    padre boolean,
    activo boolean,
     FOREIGN KEY (tipoCategoriaID) REFERENCES tipoCategoria(ID));

INSERT INTO categorias (nombre, tipoCategoriaID, padre, activo) VALUES
	('Peluqueria','1',0,1);
INSERT INTO categorias (nombre, tipoCategoriaID, padre, activo) VALUES
	('Maquillaje','3',1,0);
INSERT INTO categorias (nombre, tipoCategoriaID, padre, activo) VALUES
	('Podologo','4',1,1);
		

