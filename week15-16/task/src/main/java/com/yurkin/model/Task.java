package com.yurkin.model;

import java.io.Serializable;

public class Task implements Serializable {
    private final String filePath;

    public Task(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}