create database ecommerce;
use ecommerce;

create table Cliente(
	id int primary key,
	nome varchar(50),
    email varchar(255),
    salario double
);

create table Pedido(
	id int primary key auto_increment,
    dataPedido datetime,
    idCliente int,
    foreign key (idCliente) references Cliente(id)
);

create table Categoria(
	id int primary key auto_increment,
    nome varchar(50)
);

create table Produto(
	id int primary key auto_increment,
    nome varchar(50),
    preco double,
    idCategoria int,
    foreign key (idCategoria) references Categoria(id)
);

create table pedido_produto(
	idPedido int,
    idProduto int,
    quantidade int,
    foreign key (idPedido) references Pedido(id),
    foreign key (idProduto) references Produto(id)
);

insert into Categoria(nome)
values("informática"),
("Eletrônico");

insert into Produto(nome, preco, idCategoria)
values("Notebook", 3500, 1),
("TV", 2500, 2);


