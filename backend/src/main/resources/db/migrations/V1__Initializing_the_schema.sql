create table shop_user(
	login varchar(128) unique primary key,
	password varchar(64),
	name varchar(64),
	last_name varchar(64),
	phone_number varchar(64),
	check (length(password) >= 7)
);

create table user_role(
	login varchar(128),
	role_name varchar(64),
	constraint user_role_primary_key primary key(login, role_name),
	constraint login_foreign_key_to_shop_user foreign key(login) references shop_user(login)
);

create table category(
	category_name varchar(128) unique primary key
);

create table brand(
	brand_name varchar(128) unique primary key
);

create table producer(
	producer_name varchar(128) unique primary key
);

create table product(
	product_name varchar(256) unique primary key,
	for_adults bool,
	picture text,
	in_stock bool,
	price int,
	category_name varchar(128),
	brand_name varchar(128),
	producer_name varchar(128),
	cal int,
	proteins numeric(4,1),
	fats numeric(4,1),
	description text,
	carbohydrates numeric(4,1),
	check (price > 0 and proteins >= 0 and fats >= 0 and carbohydrates >= 0),
	constraint category_name_foreign_key_to_brand foreign key(category_name) references category(category_name),
	constraint brand_name_foreign_key_to_brand foreign key(brand_name) references brand(brand_name),
	constraint producer_name_foreign_key_to_brand foreign key(producer_name) references producer(producer_name)
);

create table offer(
	product_name varchar(256) unique primary key,
	new_price int,
	is_available boolean
);

create table user_order(
	order_code uuid unique primary key default gen_random_uuid(),
	date timestamp,
	user_login varchar(128),
	constraint user_login_foreign_key_to_shop_user foreign key(user_login) references shop_user(login)
);

create table order_item(
	order_code uuid,
	product_name varchar(256),
	item_count int,
	check (item_count > 0),
	constraint order_item_primary_key primary key(order_code, product_name),
	constraint order_code_foreign_key_to_user_order foreign key(order_code) references user_order(order_code),
	constraint product_name_foreign_key_to_product foreign key(product_name) references product(product_name)
);
























