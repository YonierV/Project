create database bd_web;
use bd_web;

create table productos
(ID int(20) not null,
 nombre varchar(20) default null,
 descripcion varchar(20) default null,
 tipo varchar(20) default null,
 precio varchar(20) default null
 );
 