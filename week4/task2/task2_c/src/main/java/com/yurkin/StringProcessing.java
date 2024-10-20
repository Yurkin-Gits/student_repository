package com.yurkin;

public class StringProcessing {
    public static String process(String input) {
        return input.replaceAll("(.)\\1{2,}", "$1");
    }
}
