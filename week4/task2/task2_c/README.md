# Задание 2.c
***
К сожалению вы пролили чай на Вашу клавиатуру, и теперь она залипает 😱. 
Напишите регулярное выражение, которое бы находило символы, повторяющиеся ≥ трёх раз, и заменяло их на один. Реализуйте приложение демонстрирующее работоспособность регулярного выражения. 
***

**Описание**: Этот проект реализует программу для обработки строки, заменяя последовательности одинаковых символов, которые повторяются три и более раз, на один экземпляр этого символа. 
Функции:
    Класс StringProcessing:
        Содержит метод process, который принимает строку в качестве входных данных и заменяет последовательности одинаковых символов (три или более повторений) на один символ.
        Использует регулярное выражение для поиска таких последовательностей и их замены.
    Класс Main:
        Запрашивает у пользователя ввод строки.
        Вызывает метод process из класса StringProcessing для обработки строки.
        Выводит результат после обработки строки.