drop database if exists DBejercicioBim2_in5cm;
create database DBejercicioBim2_in5cm;
use DBejercicioBim2_in5cm;

create table Clientes(
	dpi_cliente int auto_increment not null,
    nombre_cliente varchar(50) not null,
    apellido_cliente  varchar(50) not null,
    direccion varchar(100) not null,
    estado int not null,
    primary key (dpi_cliente)
);

create table Usuarios(
	codigo_usuario int auto_increment not null,
    username varchar(45) not null,
    password varchar(45) not null,
    email varchar(60) not null,
    rol varchar(45) not null,
    estado int not null,
    primary key(codigo_usuario)
);

create table Productos(
	codigo_producto int auto_increment not null,
    nombre_producto varchar(60) not null,
    precio decimal(10,2) not null,
    stock int not null,
    estado int not null,
    primary key(codigo_producto)
);

create table Ventas(
	codigo_venta int auto_increment not null,
    dpi_cliente int,
    codigo_usuario int,
	fecha_venta date not null,
	total decimal(10,2) not null,
	estado int not null,
	primary key(codigo_venta),
	constraint FK_dpi_cliente foreign key (dpi_cliente) 
    references Clientes(dpi_cliente) on delete cascade,
    constraint FK_codigo_usuario foreign key (codigo_usuario) 
    references Usuarios(codigo_usuario) on delete cascade
);

create table DetalleVenta(
	codigo_detalle_venta int auto_increment not null,
    codigo_producto int,
    codigo_venta int,
    cantidad int not null,
    precio_unitario decimal(10,2) not null,
    subtotal decimal(10,2) not null,
    primary key(codigo_detalle_venta),
    constraint FK_codigo_producto foreign key (codigo_producto) 
    references Productos(codigo_producto) on delete cascade,
    constraint FK_codigo_venta foreign key (codigo_venta) 
    references Ventas(codigo_venta) on delete cascade
);

-- ////////////////////////----CLIENTES----///////////////////////

delimiter $$

create procedure sp_ListarClientes()
begin
    select * from Clientes
    order by dpi_cliente;
end $$

delimiter ;

delimiter $$

create procedure sp_AgregarCliente(
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    insert into Clientes(nombre_cliente, apellido_cliente, direccion, estado)
    values(p_nombre, p_apellido, p_direccion, p_estado);
end $$

delimiter ;

delimiter $$

create procedure sp_ActualizarCliente(
    in p_dpi int,
    in p_nombre varchar(50),
    in p_apellido varchar(50),
    in p_direccion varchar(100),
    in p_estado int
)
begin
    update Clientes
    set nombre_cliente = p_nombre,
        apellido_cliente = p_apellido,
        direccion = p_direccion,
        estado = p_estado
    where dpi_cliente = p_dpi;
end $$

delimiter ;

delimiter $$

create procedure sp_EliminarCliente(in p_dpi int)
begin
    delete from Clientes where dpi_cliente = p_dpi;
end $$

delimiter ;

delimiter $$

create procedure sp_BuscarClientePorId(in p_dpi int)
begin
    select * from Clientes where dpi_cliente = p_dpi;
end $$

delimiter ;


-- ////////////////////////----USUARIOS----///////////////////////

delimiter $$

create procedure sp_ListarUsuarios()
begin
    select * from Usuarios
    order by codigo_usuario;
end $$

delimiter ;

delimiter $$

create procedure sp_AgregarUsuario(
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(60),
    in p_rol varchar(45),
    in p_estado int
)
begin
    insert into Usuarios(username, password, email, rol, estado)
    values(p_username, p_password, p_email, p_rol, p_estado);
end $$

delimiter ;

delimiter $$

create procedure sp_ActualizarUsuario(
    in p_codigo int,
    in p_username varchar(45),
    in p_password varchar(45),
    in p_email varchar(60),
    in p_rol varchar(45),
    in p_estado int
)
begin
    update Usuarios
    set username = p_username,
        password = p_password,
        email = p_email,
        rol = p_rol,
        estado = p_estado
    where codigo_usuario = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_EliminarUsuario(in p_codigo int)
begin
    delete from Usuarios where codigo_usuario = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_BuscarUsuarioPorId(in p_codigo int)
begin
    select * from Usuarios where codigo_usuario = p_codigo;
end $$

delimiter ;


-- ////////////////////////----PRODUCTOS----///////////////////////

delimiter $$

create procedure sp_ListarProductos()
begin
    select * from Productos
    order by codigo_producto;
end $$

delimiter ;

delimiter $$

create procedure sp_AgregarProducto(
    in p_nombre varchar(60),
    in p_precio decimal(10,2),
    in p_stock int,
    in p_estado int
)
begin
    insert into Productos(nombre_producto, precio, stock, estado)
    values(p_nombre, p_precio, p_stock, p_estado);
end $$

delimiter ;

delimiter $$

create procedure sp_ActualizarProducto(
    in p_codigo int,
    in p_nombre varchar(60),
    in p_precio decimal(10,2),
    in p_stock int,
    in p_estado int
)
begin
    update Productos
    set nombre_producto = p_nombre,
        precio = p_precio,
        stock = p_stock,
        estado = p_estado
    where codigo_producto = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_EliminarProducto(in p_codigo int)
begin
    delete from Productos where codigo_producto = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_BuscarProductoPorId(in p_codigo int)
begin
    select * from Productos where codigo_producto = p_codigo;
end $$

delimiter ;


-- ////////////////////////----VENTAS----///////////////////////

delimiter $$

create procedure sp_ListarVentas()
begin
    select * from Ventas
    order by codigo_venta;
end $$

delimiter ;

delimiter $$

create procedure sp_AgregarVenta(
    in p_dpi_cliente int,
    in p_codigo_usuario int,
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int
)
begin
    insert into Ventas(dpi_cliente, codigo_usuario, fecha_venta, total, estado)
    values(p_dpi_cliente, p_codigo_usuario, p_fecha, p_total, p_estado);
end $$

delimiter ;

delimiter $$

create procedure sp_ActualizarVenta(
    in p_codigo int,
    in p_dpi_cliente int,
    in p_codigo_usuario int,
    in p_fecha date,
    in p_total decimal(10,2),
    in p_estado int
)
begin
    update Ventas
    set dpi_cliente = p_dpi_cliente,
        codigo_usuario = p_codigo_usuario,
        fecha_venta = p_fecha,
        total = p_total,
        estado = p_estado
    where codigo_venta = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_EliminarVenta(in p_codigo int)
begin
    delete from Ventas where codigo_venta = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_BuscarVentaPorId(in p_codigo int)
begin
    select * from Ventas where codigo_venta = p_codigo;
end $$

delimiter ;


-- ////////////////////////----DETALLE VENTA----///////////////////////

delimiter $$

create procedure sp_ListarDetalleVenta()
begin
    select * from DetalleVenta
    order by codigo_detalle_venta;
end $$

delimiter ;

delimiter $$

create procedure sp_AgregarDetalleVenta(
    in p_codigo_producto int,
    in p_codigo_venta int,
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2)
)
begin
    insert into DetalleVenta(codigo_producto, codigo_venta, cantidad, precio_unitario, subtotal)
    values(p_codigo_producto, p_codigo_venta, p_cantidad, p_precio, p_subtotal);
end $$

delimiter ;

delimiter $$

create procedure sp_ActualizarDetalleVenta(
    in p_codigo int,
    in p_codigo_producto int,
    in p_codigo_venta int,
    in p_cantidad int,
    in p_precio decimal(10,2),
    in p_subtotal decimal(10,2)
)
begin
    update DetalleVenta
    set codigo_producto = p_codigo_producto,
        codigo_venta = p_codigo_venta,
        cantidad = p_cantidad,
        precio_unitario = p_precio,
        subtotal = p_subtotal
    where codigo_detalle_venta = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_EliminarDetalleVenta(in p_codigo int)
begin
    delete from DetalleVenta where codigo_detalle_venta = p_codigo;
end $$

delimiter ;

delimiter $$

create procedure sp_BuscarDetalleVentaPorId(in p_codigo int)
begin
    select * from DetalleVenta where codigo_detalle_venta = p_codigo;
end $$

delimiter ;

-- ///////////////////////////////// ---------------- REGISTROS ------------------ ////////////////////////////////
-- =========================================
-- CLIENTES (5 REGISTROS)
-- =========================================

call sp_AgregarCliente('Juan','Perez','Zona 1 Guatemala',1);
call sp_AgregarCliente('Maria','Lopez','Zona 5 Guatemala',1);
call sp_AgregarCliente('Carlos','Gomez','Zona 10 Guatemala',1);
call sp_AgregarCliente('Ana','Martinez','Zona 3 Guatemala',1);
call sp_AgregarCliente('Luis','Ramirez','Zona 7 Guatemala',1);


-- =========================================
-- USUARIOS (5 REGISTROS)
-- =========================================

call sp_AgregarUsuario('admin1','1234','admin1@gmail.com','Administrador',1);
call sp_AgregarUsuario('user1','1234','user1@gmail.com','Vendedor',1);
call sp_AgregarUsuario('user2','1234','user2@gmail.com','Vendedor',1);
call sp_AgregarUsuario('user3','1234','user3@gmail.com','Supervisor',1);
call sp_AgregarUsuario('user4','1234','user4@gmail.com','Cajero',1);


-- =========================================
-- PRODUCTOS (5 REGISTROS)
-- =========================================

call sp_AgregarProducto('Laptop Dell',7500.00,10,1);
call sp_AgregarProducto('Mouse Logitech',150.00,50,1);
call sp_AgregarProducto('Teclado Mecánico',350.00,30,1);
call sp_AgregarProducto('Monitor 24 pulgadas',1200.00,20,1);
call sp_AgregarProducto('Impresora HP',900.00,15,1);


-- =========================================
-- VENTAS (5 REGISTROS)
-- =========================================

call sp_AgregarVenta(1,1,'2026-03-01',7650.00,1);
call sp_AgregarVenta(2,2,'2026-03-02',150.00,1);
call sp_AgregarVenta(3,3,'2026-03-03',350.00,1);
call sp_AgregarVenta(4,4,'2026-03-04',1200.00,1);
call sp_AgregarVenta(5,5,'2026-03-05',900.00,1);


-- =========================================
-- DETALLE VENTA (5 REGISTROS)
-- =========================================

call sp_AgregarDetalleVenta(1,1,1,7500.00,7500.00);
call sp_AgregarDetalleVenta(2,2,1,150.00,150.00);
call sp_AgregarDetalleVenta(3,3,1,350.00,350.00);
call sp_AgregarDetalleVenta(4,4,1,1200.00,1200.00);
call sp_AgregarDetalleVenta(5,5,1,900.00,900.00);