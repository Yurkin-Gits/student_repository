package com.yurkin;
import java.util.Scanner;

public class Main 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String userName = scanner.nextLine();
        scanner.close();
        System.out.println("Привет, " + userName + "!");
    }
}
