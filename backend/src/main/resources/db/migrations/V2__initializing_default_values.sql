insert into shop_user values
('admin', '{bcrypt}$2y$10$1amoPIu7BlgtkTshSjrQbeeSwqjLAE7vI7iOpzeSDlbXlBpWo0CJS', 'admin', 'admin', ''),
('example@mail.ru', '{bcrypt}$2y$10$ETBa83fecXgpHMhESpTMxOu0JVfI6o7q3V7dHzTQ2zd0ei8g53fdi', 'Пётр', 'Юхлимов', '+79093601272');

insert into user_role values
('admin', 'ROLE_ADMIN'),
('example@mail.ru', 'ROLE_CUSTOMER');

insert into category values
('Яйца', 7),('Молоко', 7),('Хлеб', 7),('Творог', 7),('Шоколад', 4),('Варенье', 0),('Мясо', 0);

insert into brand values
('Золотой стандарт', 5),('Серебряный стандарт', 5),('Магия', 5),('Корова несушка', 5),('Магуайр', 4),('Ролс Роликс', 4),('Рыжая собака', 4);

insert into producer values
('Северный завод', 7),('Нижне-Верхний уральский металостроительный комбинат', 7),('Урюк', 7),('Ванечкин садик', 7),('УлГТУ', 4),('ИП Жора', 0),('Красная икра со скидкой', 0);

insert into product values
('Яйца по куриному', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 100, 'Яйца', 'Корова несушка', 'Урюк', 10, 3.0, 4.0, 'Длинный длинный текст', 5.0),
('Яйца коровьи', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 110, 'Яйца', 'Магия', 'Урюк', 11, 4.0, 14.0, 'Длинный предлинный текст', 5.1),
('Яйца свиные', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 95, 'Яйца', 'Серебряный стандарт', 'Урюк', 12, 42.0, 1.0, 'Длинный предлинный текст, это так', 5.2),
('Яйца лошадиные', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 150, 'Яйца', 'Магуайр', 'Урюк', 1, 41.0, 24.0, 'Самый длинный предлинный текст', 5.3),
('Яйца гусиные', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 110, 'Яйца', 'Золотой стандарт', 'Урюк', 42, 41.0, 22.0, 'Длинный предлинный текст', 5.4),
('Яйца утиные', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 145, 'Яйца', 'Ролс Роликс', 'Урюк', 11, 4.0, 14.0, 'Наидлиннейший текст', 5.5),
('Яйца волшебные', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 500, 'Яйца', 'Рыжая собака', 'Урюк', 11, 4.0, 14.0, 'Здесь могла быть реклама', 5.6),
('Молоко куриное', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 50, 'Молоко', 'Золотой стандарт', 'Северный завод', 1, 4.0, 1.0, 'Текст, текст', 5.7),
('Молоко коровье', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 60, 'Молоко', 'Серебряный стандарт', 'Северный завод', 2, 5.0, 2.0, 'Текст, не текст', 5.8),
('Молоко свиное', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 70, 'Молоко', 'Магия', 'Северный завод', 3, 6.0, 3.0, 'Не текст, текст', 5.9),
('Молоко лошадиное', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 80, 'Молоко', 'Корова несушка', 'Северный завод', 4, 4.0, 4.0, 'Текст, текст', 6.0),
('Молоко гусиное', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 90, 'Молоко', 'Магуайр', 'Северный завод', 5, 3.0, 5.0, 'кст, рекст', 6.1),
('Молоко утиное', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 100, 'Молоко', 'Ролс Роликс', 'Северный завод', 6, 4.0, 6.0, 'тскет , тскеТ', 6.2),
('Молоко волшебное', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 500, 'Молоко', 'Рыжая собака', 'Северный завод', 7, 4.0, 7.0, 'Лотгар огар', 6.3),
('Хлеб куриный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 50, 'Хлеб', 'Золотой стандарт', 'Нижне-Верхний уральский металостроительный комбинат', 1, 5.0, 1.0, 'аннигиляторная пушка', 5.1),
('Хлеб коровий', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 60, 'Хлеб', 'Серебряный стандарт', 'Нижне-Верхний уральский металостроительный комбинат', 2, 5.0, 2.0, 'деаннигиляторная пушка', 5.2),
('Хлеб свиной', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 70, 'Хлеб', 'Магия', 'Нижне-Верхний уральский металостроительный комбинат', 3, 5.0, 3.0, 'нигиляторная пушка', 5.3),
('Хлеб лошадиный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 80, 'Хлеб', 'Корова несушка', 'Нижне-Верхний уральский металостроительный комбинат', 4, 5.0, 4.0, 'аннигиляторная ушка', 5.4),
('Хлеб гусиный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 90, 'Хлеб', 'Магуайр', 'Нижне-Верхний уральский металостроительный комбинат', 5, 5.0, 5.0, 'аннигиняшная шушка', 5.5),
('Хлеб утиный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 100, 'Хлеб', 'Ролс Роликс', 'Нижне-Верхний уральский металостроительный комбинат', 6, 5.0, 6.0, 'пушка', 5.6),
('Хлеб ванильный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 1150, 'Хлеб', 'Рыжая собака', 'Нижне-Верхний уральский металостроительный комбинат', 7, 5.0, 7.0, 'аннигиляторная пуршка', 5.7),
('Творог куриный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 50, 'Творог', 'Золотой стандарт', 'Ванечкин садик', 1, 6.0, 1.0, 'плохая музыка', 5.1),
('Творог коровий', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 65, 'Творог', 'Серебряный стандарт', 'Ванечкин садик', 2, 6.0, 2.0, 'лохая музыка', 5.2),
('Творог свиной', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 75, 'Творог', 'Магия', 'Ванечкин садик', 3, 6.0, 3.0, 'похая музыка', 5.3),
('Творог лошадиный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 85, 'Творог', 'Корова несушка', 'Ванечкин садик', 4, 6.0, 4.0, 'плохая узыка', 5.4),
('Творог гусиный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 95, 'Творог', 'Магуайр', 'Ванечкин садик', 5, 6.0, 5.0, 'хая хой', 5.5),
('Творог утиный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 105, 'Творог', 'Ролс Роликс', 'Ванечкин садик', 6, 6.0, 6.0, 'лохя мыка', 5.1),
('Творог волшебный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 505, 'Творог', 'Рыжая собака', 'Ванечкин садик', 7, 6.0, 7.0, 'хорошая музыка', 5.7),
('Шоколад куриный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 51, 'Шоколад', 'Золотой стандарт', 'УлГТУ', 1, 7.0, 1.0, 'Камеру вырубай', 6.1),
('Шоколад коровий', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 51, 'Шоколад', 'Серебряный стандарт', 'УлГТУ', 1, 7.0, 1.0, 'меру вырубай', 6.2),
('Шоколад свиной', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 71, 'Шоколад', 'Магия', 'УлГТУ', 3, 7.0, 3.0, 'Керу вырубай', 6.3),
('Шоколад лошадиный', false, 'https://freepngclipart.com/download/cat/81951-and-play-pet-kitten-dog-cat-cats.png', true, 80, 'Шоколад', 'Корова несушка', 'УлГТУ', 4, 7.0, 4.0, 'Камеру врубай', 6.4);

insert into user_order values
('f9d62bf2-498c-11ee-be56-0242ac120002', '2023-09-02 12:45:30', 'example@mail.ru'),
('549142de-498d-11ee-be56-0242ac120002', '2023-04-20 15:31:50', 'example@mail.ru'),
('58d5cefa-498d-11ee-be56-0242ac120002', '2023-07-13 08:14:13', 'example@mail.ru'),
('5e66ae84-498d-11ee-be56-0242ac120002', '2023-09-01 21:43:40', 'example@mail.ru');

insert into order_item values
('f9d62bf2-498c-11ee-be56-0242ac120002', 'Творог куриный', 2),
('f9d62bf2-498c-11ee-be56-0242ac120002', 'Молоко волшебное', 1),
('549142de-498d-11ee-be56-0242ac120002', 'Шоколад лошадиный', 1),
('549142de-498d-11ee-be56-0242ac120002', 'Творог гусиный', 3),
('58d5cefa-498d-11ee-be56-0242ac120002', 'Хлеб утиный', 1),
('58d5cefa-498d-11ee-be56-0242ac120002', 'Молоко волшебное', 4),
('5e66ae84-498d-11ee-be56-0242ac120002', 'Творог гусиный', 1);