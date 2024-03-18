DROP TABLE Vehiculo;
DROP TABLE Persona;
DROP TABLE Especialidad;
DROP TABLE Marca;
DROP TABLE Cargo;
DROP TABLE Comuna;

CREATE TABLE Marca (

    idMarca             int             primary key auto_increment,
    nombre              varchar(50)     not null,
    UNIQUE(nombre)
);

CREATE TABLE Cargo
(
    idCargo             int             primary key auto_increment,
    nombre              varchar(50)     not null,
    UNIQUE(nombre)
);

CREATE TABLE Especialidad
(
    idEspecialidad      int             primary key auto_increment,
    nombre              varchar(50)     not null,
    habilitado int not null,
    UNIQUE(nombre)
);

CREATE TABLE Comuna
(
    idComuna            int             primary key auto_increment,
    nombre              varchar(50)     not null,
    UNIQUE(nombre)
);

CREATE TABLE Persona
(
    idPersona           int             primary key auto_increment,
    idCargo             int             not null,
    idEspecialidad      int             not null,
    idComuna            int             not null,
    rut                 int             not null,
    digito              varchar(1)      not null,
    nombre              varchar(50)     not null,
    apellido            varchar(50)     not null,
    sueldo              int not null,    
    esCliente           boolean,
    habilitado          boolean,
    UNIQUE(rut),
    FOREIGN KEY(idCargo)                     REFERENCES Cargo(idCargo),
    FOREIGN KEY(idEspecialidad)              REFERENCES Especialidad(idEspecialidad),
    FOREIGN KEY(idComuna)                    REFERENCES Comuna(idComuna)

);

CREATE TABLE Vehiculo
(
    idVehiculo          int             primary key auto_increment,
    idPersona           int             not null,
    idMarca             int             not null,
    patente             varchar(6)      not null,
    modelo              varchar(100)    not null,
    litrosMaletero      int,
    cantidadPuerta      int,
    largoManillar       int,
    estilo              varchar(100),
    UNIQUE(patente),
    FOREIGN KEY(idPersona)                    REFERENCES Persona(idPersona),
    FOREIGN KEY(idMarca)                    REFERENCES Marca(idMarca)

);

insert into Marca values (null, 'Toyota');
insert into Marca values (null, 'Nissan');
insert into Marca values (null, 'Hyundai');
insert into Marca values (null, 'Fiat');
insert into Marca values (null, 'Peugeot');

insert into Cargo values (null, 'Administrador');
insert into Cargo values (null, 'Gerente');
insert into Cargo values (null, 'Vendedor');
insert into Cargo values (null, 'Jefe');
insert into Cargo values (null, 'Cliente');

insert into Comuna values (null, 'Calera de Tango');
insert into Comuna values (null, 'Puente Alto');
insert into Comuna values (null, 'Vitacura');
insert into Comuna values (null, 'Providencia');
insert into Comuna values (null, 'Cerrillos');

insert into Especialidad values (null, 'Automovil', 1);
insert into Especialidad values (null, 'Motocicleta', 1);
insert into Especialidad values (null, 'Especialidad3', 1);
insert into Especialidad values (null, 'Especialidad4', 1);
insert into Especialidad values (null, 'Especialdiad5', 1);


insert into Persona values (null, 1, 1, 1, 324271, 4, 'Nombre', 'Apellido', 700000, true, false);
insert into Persona values (null, 2, 2, 2, 384834, 7, 'Nombre', 'Apellido', 800000, true, true);
insert into Persona values (null, 3, 3, 3, 928232, 4, 'Nombre', 'Apellido', 900000, false, true);
insert into Persona values (null, 4, 4, 4, 232823, 6, 'Nombre', 'Apellido', 950000, false, false);
insert into Persona values (null, 5, 5, 5, 123456, 8, 'Nombre', 'Apellido', 1000000, true, false);

insert into Vehiculo  values (null, 1,1, '123456', 'Modelo', 100, 4, 40, 'Estilo1');
insert into Vehiculo values (null, 2,2,'ABCD12', 'Modelo', 150, 2, 20, 'Estilo2');
insert into Vehiculo values (null,3,3, 'QWER23', 'Modelo', 110, 4, 30, 'Estilo3');
insert into Vehiculo values (null,4,4, 'MNBV82', 'Modelo', 130, 2, 50, 'Estilo4');
insert into Vehiculo values (null,5,5, 'PQWE32', 'Modelo', 140, 4, 10, 'Estilo5');

