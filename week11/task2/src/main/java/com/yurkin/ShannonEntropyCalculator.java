package com.yurkin;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

class ShannonEntropyCalculator implements Runnable {
    private final String filePath;
    private final long start;
    private final long end;
    private Map<Byte, Long> frequencyMap;
    private long totalBytes;

    public ShannonEntropyCalculator(String filePath, long start, long end) {
        this.filePath = filePath;
        this.start = start;
        this.end = end;
        this.frequencyMap = new HashMap<>();
        this.totalBytes = 0;
    }

    @Override
    public void run() {
        try (RandomAccessFile raf = new RandomAccessFile(filePath, "r")) {
            raf.seek(start);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(raf.getFD()));
            byte[] buffer = new byte[1024 * 1024]; // Читаем файл частями по 1 MB

            long bytesRemaining = end - start;
            while (bytesRemaining > 0) {
                int bytesToRead = (int) Math.min(buffer.length, bytesRemaining);
                int bytesRead = bis.read(buffer, 0, bytesToRead);
                if (bytesRead == -1) break;

                totalBytes += bytesRead;
                for (int i = 0; i < bytesRead; i++) {
                    byte b = buffer[i];
                    frequencyMap.put(b, frequencyMap.getOrDefault(b, 0L) + 1);
                }

                bytesRemaining -= bytesRead;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Byte, Long> getFrequencyMap() {
        return frequencyMap;
    }

    public long getTotalBytes() {
        return totalBytes;
    }
}