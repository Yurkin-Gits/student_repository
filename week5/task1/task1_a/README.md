# Задание 1.a
***
Напишите программу, которая открывает и выводит на экран содержимое текстового файла.
При возникновении ошибок, выводите сообщения на экран в соответствии с возникшей ошибкой.
***

**Описание**: Данный проект реализует программу для чтения данных из файла с использованием класса FileReader. Программа считывает содержимое выбранного текстового файла, выводит его на экран и обрабатывает возможные ошибки.
Функции:
Класс FileReader:
    Запрашивает путь к файлу: "src/main/java/com/yurkin/data_file.txt".
    Использует метод Files.readString для чтения содержимого файла.
    Выводит содержимое файла на экран.
Обработка ошибок:
    NoSuchFileException: Выводит сообщение об ошибке, если файл не найден.
    IOException: Выводит сообщение, если произошла ошибка при чтении файла.
    NumberFormatException: Выводит сообщение, если данные в файле имеют неправильный формат (например, если ожидается числовое значение).