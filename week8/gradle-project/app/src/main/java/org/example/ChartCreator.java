package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

public class ChartCreator {
    public void createChart(Map<Integer, Double> recursiveTimes, Map<Integer, Double> optimizedTimes) {
        List<Double> xData = new ArrayList<>();
        List<Double> recursiveData = new ArrayList<>();
        List<Double> optimizedData = new ArrayList<>();

        for (Map.Entry<Integer, Double> entry : recursiveTimes.entrySet()) {
            xData.add(entry.getKey().doubleValue());
            recursiveData.add(entry.getValue());
        }

        for (Map.Entry<Integer, Double> entry : optimizedTimes.entrySet()) {
            optimizedData.add(entry.getValue());
        }

        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Сравнение времени выполнения методов Фибоначчи")
                .xAxisTitle("Число Фибоначчи")
                .yAxisTitle("Время выполнения (мс)")
                .build();

        chart.addSeries("Рекурсивный", xData, recursiveData);
        chart.addSeries("Оптимизированный", xData, optimizedData);

        new SwingWrapper<>(chart).displayChart();
    }
}
