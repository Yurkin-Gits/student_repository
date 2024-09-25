package com.yurkin;

public class App 
{
    public static void main( String[] args )
    {
        // Для целых чисел:
        // byte занимает 8 бит и может хранить значения от -128 до 127 (2^7 = 128)
        System.out.println("Byte: ");
        System.out.println("Минимум: " + Byte.MIN_VALUE);
        System.out.println("Максимум: " + Byte.MAX_VALUE);

        // short занимает 16 бит и может хранить значения от -32,768 до 32,767 (2^15 = 32768)
        System.out.println("Short: ");
        System.out.println("Минимум: " + Short.MIN_VALUE);
        System.out.println("Максимум: " + Short.MAX_VALUE);

        // int занимает 32 бита и может хранить значения от -2^31 до 2^31-1
        System.out.println("Int: ");
        System.out.println("Минимум: " + Integer.MIN_VALUE);
        System.out.println("Максимум: " + Integer.MAX_VALUE);

        // long занимает 64 бита и может хранить значения от -2^63 до 2^63-1
        System.out.println("Long: ");
        System.out.println("Минимум: " + Long.MIN_VALUE);
        System.out.println("Максимум: " + Long.MAX_VALUE);

        // Для чисел с плавающей запятой:
        // float представляет собой число с плавающей точкой одинарной точности (32 бита) по стандарту IEEE 754
        System.out.println("Float: ");
        System.out.println("Минимум: " + Float.MIN_VALUE);  // Минимальное положительное значение
        System.out.println("Максимум: " + Float.MAX_VALUE);  // Максимальное значение
        System.out.println("Положительная бесконечность: " + Float.POSITIVE_INFINITY);
        System.out.println("Отрицательная бесконечность: " + Float.NEGATIVE_INFINITY);

        // double представляет собой число с плавающей точкой двойной точности (64 бита) по стандарту IEEE 754
        System.out.println("Double: ");
        System.out.println("Минимум: " + Double.MIN_VALUE);  // Минимальное положительное значение
        System.out.println("Максимум: " + Double.MAX_VALUE);  // Максимальное значение
        System.out.println("Положительная бесконечность: " + Double.POSITIVE_INFINITY);
        System.out.println("Отрицательная бесконечность: " + Double.NEGATIVE_INFINITY);
    }
}
