# Задание 2.b
***
Напишите регулярное выражение, проверяющее на правильность введенный адрес IPv6 (полная, НЕ сокращенная форма). Реализуйте приложение демонстрирующее работоспособность регулярного выражения. 
***

**Описание**: Этот проект реализует два класса: Main и IPChecker, которые позволяют проверять корректность введённого адреса IPv6 с использованием регулярных выражений.
Функции:
    Класс IPChecker:
        Содержит метод validate, который принимает адрес IPv6 в качестве входных данных и проверяет его соответствие заданному регулярному выражению.
        Использует регулярное выражение для определения допустимого формата IPv6 адреса, который включает восемь групп по четыре шестнадцатеричных символа, разделённых двоеточиями.
    Класс Main:
        Запрашивает у пользователя ввод IPv6 адреса.
        Создает объект IPChecker и вызывает метод validate.
        Выводит сообщение о том, является ли введённый адрес IPv6 корректным или некорректным.