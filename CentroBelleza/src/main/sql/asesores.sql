drop database if exists centrosBelleza;
create database centrosBelleza  character set latin1 collate latin1_spanish_Ci;
USE centrosBelleza;

create table personas (
	ID varchar(5) primary key auto_increment,
    nombre varchar(50),
    documento varchar(9),
    fechaNacimiento date,
    direccion varchar(50),
    localidad varchar(30),
    cp varchar (5);
    provinciaID varchar (3);
    email varchar (30);
    telefono varchar (9);
    comunicaciones varchar (30),
    fechaAlta date,
    IP varchar (20),
    activo boolean);

INSERT INTO personas (ID, nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
				IP,activo) VALUES
	('00001', 'Andres Pino Gallardo','30999999J','1981-03-03','C/ Molino,12', 'Luecna', '14900',
		'4','and@g.com', '957000000','Nose','2000-06-01','90','si');