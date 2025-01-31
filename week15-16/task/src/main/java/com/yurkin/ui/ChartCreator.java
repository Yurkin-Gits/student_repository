package com.yurkin.ui;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.DefaultCategoryDataset;

public class ChartCreator {
    public static void createHistogram(Map<Integer, Map<String, Integer>> yearlyMaxPrices) {
        if (yearlyMaxPrices == null || yearlyMaxPrices.isEmpty()) {
            System.err.println("Нет данных для построения гистограммы.");
            return;
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<Integer, Map<String, Integer>> yearEntry : yearlyMaxPrices.entrySet()) {
            Integer year = yearEntry.getKey();
            for (Map.Entry<String, Integer> cityEntry : yearEntry.getValue().entrySet()) {
                String city = cityEntry.getKey();
                Integer price = cityEntry.getValue();
                dataset.addValue(price / 1000, city, String.valueOf(year));
            }
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Наибольшие цены по городам по годам",
                "Год",
                "Цена",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis yAxis = new NumberAxis("Цена");
        NumberFormat numberFormat = new DecimalFormat("#,###");
        yAxis.setNumberFormatOverride(numberFormat);
        yAxis.setAutoRangeIncludesZero(true);
        plot.setRangeAxis(yAxis);

        JFrame frame = new JFrame("Гистограмма");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);
    }
}