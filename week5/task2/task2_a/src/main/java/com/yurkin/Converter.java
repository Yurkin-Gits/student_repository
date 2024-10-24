package com.yurkin;

public class Converter {

    public static Object convert(String message, int option) {
        Object result = null;

        switch (option) {
            case 1 -> {
                try {
                    result = Byte.parseByte(message.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Невозможно преобразовать в byte: значение должно быть целым числом от " +
                            Byte.MIN_VALUE + " до " + Byte.MAX_VALUE + ". Введено: '" + message + "'.");
                }
            }
            case 2 -> {
                try {
                    result = Short.parseShort(message.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Невозможно преобразовать в short: значение должно быть целым числом от " +
                            Short.MIN_VALUE + " до " + Short.MAX_VALUE + ". Введено: '" + message + "'.");
                }
            }
            case 3 -> {
                try {
                    result = Integer.parseInt(message.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Невозможно преобразовать в int: значение должно быть целым числом от " +
                            Integer.MIN_VALUE + " до " + Integer.MAX_VALUE + ". Введено: '" + message + "'.");
                }
            }
            case 4 -> {
                try {
                    result = Long.parseLong(message.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Невозможно преобразовать в long: значение должно быть целым числом от " +
                            Long.MIN_VALUE + " до " + Long.MAX_VALUE + ". Введено: '" + message + "'.");
                }
            }
            case 5 -> {
                try {
                    result = Float.parseFloat(message.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Невозможно преобразовать в float: значение должно быть числом с плавающей точкой. Введено: '" + message + "'.");
                }
            }
            case 6 -> {
                try {
                    result = Double.parseDouble(message.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Невозможно преобразовать в double: значение должно быть числом с плавающей точкой. Введено: '" + message + "'.");
                }
            }
            case 7 -> {
                if (message.length() == 1) {
                    result = message.charAt(0);
                } else {
                    System.out.println("Невозможно преобразовать в char: строка должна содержать ровно один символ. Введено: '" + message + "'.");
                }
            }
            case 8 -> {
                if (message.trim().equalsIgnoreCase("true") || message.trim().equalsIgnoreCase("false")) {
                    result = Boolean.parseBoolean(message.trim());
                } else {
                    System.out.println("Невозможно преобразовать в boolean: допустимые значения 'true' или 'false'. Введено: '" + message + "'.");
                }
            }
            default -> System.out.println("Неверный выбор.");
        }

        return result;
    }
}
