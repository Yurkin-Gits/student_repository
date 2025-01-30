package com.yurkin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        if (args.length != 2) {
            logger.error("Использование: java -jar PrimeFinder.jar <начало> <конец>");
            return;
        }

        int start, end;
        try {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            logger.error("Ошибка: Аргументы должны быть целыми числами.");
            return;
        }

        if (start < 1 || end <= start) {
            logger.error("Ошибка: Некорректный диапазон. Начало должно быть >= 1, а конец > начала.");
            return;
        }

        logger.info("Поиск простых чисел в диапазоне от {} до {}...", start, end);

        long startTime = System.currentTimeMillis();
        List<Integer> primesWorkStealing = PrimeCalculator.findPrimesWorkStealing(start, end);
        long endTime = System.currentTimeMillis();
        long workStealingTime = endTime - startTime;
        logger.info("Work Stealing: {} мс | Найдено: {} простых чисел", workStealingTime, primesWorkStealing.size());

        startTime = System.currentTimeMillis();
        List<Integer> primesShuffle = PrimeCalculator.findPrimesShuffle(start, end);
        endTime = System.currentTimeMillis();
        long shuffleTime = endTime - startTime;
        logger.info("Shuffle: {} мс | Найдено: {} простых чисел", shuffleTime, primesShuffle.size());

        if (workStealingTime < shuffleTime) {
            logger.info("Work Stealing быстрее на {} мс.", shuffleTime - workStealingTime);
        } else if (shuffleTime < workStealingTime) {
            logger.info("Shuffle оказался быстрее на {} мс.", workStealingTime - shuffleTime);
        } else {
            logger.info("Оба метода показали одинаковое время.");
        }
    }
}
