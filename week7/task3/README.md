# Задание 3
***

Напишите программу для поиска файлов по названию или содержимому (для текстовых файлов) в выбранной директории.

***

**Описание**: Программа выполняет поиск файлов в указанной директории на основе выбранного критерия: по имени файла или по содержимому. Пользователь вводит путь к директории, затем выбирает тип поиска и указывает необходимые данные для фильтрации. Результатом является список файлов, удовлетворяющих запросу.

## Функции:

### Класс Main
Класс `Main` управляет основным взаимодействием с пользователем. Он запрашивает путь к директории и тип поиска, затем вызывает методы класса `Searcher` для выполнения поиска. Результаты поиска выводятся на экран.

### Класс Searcher
Класс `Searcher` предоставляет два метода для поиска файлов:
- `searchByName`: Поиск файлов по имени или части имени.
- `searchByContent`: Поиск файлов по содержимому, с указанием ключевого слова для поиска в тексте файлов.

Методы класса используют потоки для обхода файлов в указанной директории и возвращают список путей к найденным файлам.

***
