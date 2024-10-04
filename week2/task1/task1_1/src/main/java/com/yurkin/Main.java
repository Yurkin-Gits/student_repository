package com.yurkin;

public class Main {
    public static void main(String[] args) {
        Game game1 = new Game();
        Game game2 = new Game("Mortal Kombat 1", 2023, "Fighting");
        Game game3 = new Game("Minecraft", 2011, "Sandbox");

        game1.setName("Euro Truck Simulator");
        game1.setYearRelease(2008);
        game1.setGenre("Simulator");

        game1.printGameInfo();
        game2.printGameInfo();
        game3.printGameInfo();
    }
}