package com.yurkin;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EntropyCalculator {
    private static final int THREADS = Runtime.getRuntime().availableProcessors();
    private static final int BUFFER_SIZE = 8 * 1024 * 1024; // 8MB
    private static final int BYTE_RANGE = 256;

    public double calculate(RandomAccessFile file) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(THREADS);
        FileChannel channel = file.getChannel();
        long fileSize = channel.size();
        
        // 1. Per-thread статистика
        long[][] localCounts = new long[THREADS][BYTE_RANGE];
        CountDownLatch latch = new CountDownLatch(THREADS);

        // 2. Memory-mapped чтение
        for (int i = 0; i < THREADS; i++) {
            final int threadId = i;
            executor.submit(() -> {
                try {
                    long start = threadId * (fileSize / THREADS);
                    long end = (threadId == THREADS-1) ? fileSize : start + (fileSize / THREADS);
                    
                    MappedByteBuffer buffer = channel.map(
                        FileChannel.MapMode.READ_ONLY, 
                        start, 
                        end - start
                    );
                    
                    byte[] chunk = new byte[BUFFER_SIZE];
                    long[] counts = localCounts[threadId];
                    
                    while (buffer.hasRemaining()) {
                        int bytesToRead = Math.min(buffer.remaining(), BUFFER_SIZE);
                        buffer.get(chunk, 0, bytesToRead);
                        processChunk(chunk, bytesToRead, counts);
                    }
                    
                    latch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
        latch.await();
        
        // 3. Агрегация результатов
        long[] totalCounts = new long[BYTE_RANGE];
        long totalBytes = 0;
        for (long[] counts : localCounts) {
            for (int i = 0; i < BYTE_RANGE; i++) {
                totalCounts[i] += counts[i];
                totalBytes += counts[i];
            }
        }

        // 4. Расчет энтропии
        return calculateEntropy(totalCounts, totalBytes);
    }

    private void processChunk(byte[] chunk, int length, long[] counts) {
        for (int i = 0; i < length; i++) {
            counts[chunk[i] & 0xFF]++;
        }
    }

    private double calculateEntropy(long[] counts, long total) {
        double entropy = 0.0;
        double log2 = Math.log(2);
        
        for (long count : counts) {
            if (count == 0) continue;
            double p = (double) count / total;
            entropy -= p * (Math.log(p) / log2);
        }
        return entropy;
    }
}
