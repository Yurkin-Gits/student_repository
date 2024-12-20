package com.yurkin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainTest {

    @Test
    public void testSaveResultsToJson() {
        List<Result> results = new ArrayList<>();
        results.add(new Result(1, 1, 0.5, 1, 0.1));
        results.add(new Result(2, 1, 0.6, 1, 0.2));

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("test_results.json");

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, results);
            assertTrue("Файл test_results.json должен быть создан", file.exists());
        } catch (IOException e) {
            assert false : "Ошибка при сохранении JSON: " + e.getMessage();
        } finally {
            file.delete();
        }
    }

}
