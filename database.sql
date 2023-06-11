create database pizzadb;
use pizzadb;
create table ptype(
	type_id int primary key auto_increment,
	type_name varchar(30)
);
insert into ptype values(1,'Pizza'),(2,'Appitizea'),(3,'Salad');
create table pproduct(
	prod_id int primary key auto_increment,
	prod_name varchar(50),
	prod_price int,
	type_id int,
	foreign key(type_id) references ptype(type_id)
);
insert into pproduct values
(101,'Chicken Pizza',10000,1),(102,'Ham Pizza',11000,1),(103,'Hawaii Pizza',12000,1),
(104,'Alcho Pizza',13000,1),(105,'Doubled Cheese Pizza',14000,1),
(106,'Chicken Wings',6000,2),(107,'Potato Fired',1000,2),(108,'Squid fried',6000,2),
(109,'Tomato',500,3),(110,'Potato',600,3),(111,'Vegetables',300,3);
create table porder(
	order_id int primary key auto_increment,
	order_date date,
	customer_name varchar(20),
	customer_ph varchar(15),
	order_amount int
);
create table porder_detail(
	detail_id	int primary key auto_increment,	
	prod_id	int,
	qty int default 1,
	price	int,
	order_id int,
	foreign key(prod_id) references pproduct(prod_id),
	foreign key(order_id) references porder(order_id)
	);
show tables;
select * from porder;
select * from porder_detail;
	 