package com.yurkin;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ChartCreatorTest {

    @Test
    public void testCreateChart() {
        Map<Integer, Double> recursiveTimes = new HashMap<>();
        Map<Integer, Double> optimizedTimes = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            recursiveTimes.put(i, Math.random() * 10);
            optimizedTimes.put(i, Math.random() * 5);
        }

        ChartCreator chartCreator = new ChartCreator();
        try {
            chartCreator.createChart(recursiveTimes, optimizedTimes);
        } catch (Exception e) {
            assert false : "Ошибка при создании графика: " + e.getMessage();
        }
    }
}
