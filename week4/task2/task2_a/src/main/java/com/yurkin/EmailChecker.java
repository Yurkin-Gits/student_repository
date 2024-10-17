package com.yurkin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {
    private final String emailRegex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";

    public boolean isValid(String email) {
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
