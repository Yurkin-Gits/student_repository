package com.yurkin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPChecker {

    private static final String IPv6_PATTERN = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$";
    
    private final Pattern pattern;

    public IPChecker() {
        pattern = Pattern.compile(IPv6_PATTERN);
    }

    public boolean validate(String ipv6Address) {
        Matcher matcher = pattern.matcher(ipv6Address);
        return matcher.matches();
    }
}
