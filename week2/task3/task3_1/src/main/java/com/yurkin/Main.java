package com.yurkin;

public class Main {
    public static void main(String[] args) {
        Author verne = new Author("J.G.Verne", 1828);
        Book twoThousandLeagues = new Book("Две тысячи лье под водой", verne);
        System.out.println(twoThousandLeagues);
        Author dostoevsky = new Author("Ф. М. Достоевский", 1821);
        Book crimeAndPunishment = new Book("Преступление и наказание", dostoevsky);
        System.out.println(crimeAndPunishment);
        
    }
}