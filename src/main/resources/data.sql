DROP TABLE IF EXISTS Books;

CREATE TABLE books (
  id INT AUTO_INCREMENT UNIQUE NOT NULL,
  title VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  genre VARCHAR(250) DEFAULT NULL
);

INSERT INTO books (title, author, genre) VALUES
  ('О дивный новый мир', 'Олдос Леонард Хаксли', 'Классическая художественная проза'),
  ('Триумфальная арка', 'Эрих Ремарк', 'Роман'),
  ('Мартин Иден', 'Джек Лондон', 'Роман'),
  ('Test_1', 'Test_2', 'Test_3');