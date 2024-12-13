package com.yurkin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private int number;
    private long recursiveValue;
    private double recursiveTimeMs;
    private long optimizedValue;
    private double optimizedTimeMs;
}
