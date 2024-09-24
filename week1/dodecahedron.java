package week1;
import java.util.Scanner;

public class dodecahedron {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину ребра: ");
        Double edge = scanner.nextDouble();
        scanner.close();
        Double c = (15+7*Math.sqrt(5))/4;
        System.out.print("Объём додекаэдра равен: ");
        System.out.printf("%.1f", Math.pow(edge, 3)*c);
    }
}
