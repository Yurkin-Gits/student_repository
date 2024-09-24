package week1;
import java.util.Scanner;

public class hello_user {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        String userName = scanner.nextLine();
        scanner.close();
        System.out.println("Привет, " + userName + "!");
    }
}