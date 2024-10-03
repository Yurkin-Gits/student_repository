package com.yurkin;

public class Book {
    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        // Метод для получения названия книги
        return title;
    }

    public void setTitle(String title) {
        // Метод для установки названия книги
        this.title = title;
    }

    public Author getAuthor() {
        // Метод для получения информации об авторе книги
        return author;
    }

    public void setAuthor(Author author) {
        // Метод для установки информации об авторе книги
        this.author = author;
    }

    public void displayBookInfo() {
        // Метод для получения информации о книге
        System.out.println("Название книги: " + title);
        System.out.println("Автор: " + author.getName());
        System.out.println("Год рождения автора: " + author.getBirthYear());
    }

    public static void main(String[] args) {
        Author author = new Author("Фёдор Михайлович Достоевский", 1821);
        Book book = new Book("Преступление и наказание", author);

        book.displayBookInfo();
    }
}
