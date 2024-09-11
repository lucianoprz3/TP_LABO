drop database if exists inventario;
create database inventario;

\c inventario;

create table producto (
	id serial,
	tipo text,
	marca text,
	stock int,
	costo double precision
);

create table movimiento (
	id serial,
	id_producto int,
	cantidad int,
	fecha_y_hora date,
	costo_total double precision,
	tipo text
);

create table configuracion (
	id serial,
	stock_minimo int,
	porcentaje_costo_max double precision
);

alter table producto add constraint producto_pk primary key (id);

alter table movimiento add constraint movimiento_pk primary key (id);

alter table movimiento add constraint movimiento_id_producto_fk foreign key (id_producto) references producto(id);

alter table configuracion add constraint configuracion_pk primary key (id);

insert into configuracion (stock_minimo, porcentaje_costo_max) values(5,0.5);