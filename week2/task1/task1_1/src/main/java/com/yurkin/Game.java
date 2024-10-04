package com.yurkin;

class Game {
    private String name;
    private int yearRelease; 
    private String genre;

    public Game() {
        this.name = "Unknown";  
        this.yearRelease = 1000;          
        this.genre = "Unknown"; 
    }

    public Game(String name, int yearRelease, String genre) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.genre = genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setYearRelease(int yearRelease) {
        this.yearRelease = yearRelease;
    }

    public int getYearRelease() {
        return yearRelease;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void printGameInfo() {
        System.out.println("Название: " + this.name + ", Дата релиза: " + this.yearRelease + ", Жанр: " + this.genre);
    }

}
