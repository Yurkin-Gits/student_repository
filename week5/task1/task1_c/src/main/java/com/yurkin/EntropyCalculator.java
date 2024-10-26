package com.yurkin;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class EntropyCalculator {
    public static double calculateEntropy(FileChannel fileChannel) throws IOException {
        int bufferSize = 8192;
        ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        long[] frequencies = new long[256];
        long totalCharacters = 0;

        while (fileChannel.read(buffer) > 0) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                frequencies[b & 0xFF]++;
                totalCharacters++;
            }
            buffer.clear();
        }

        double entropy = 0.0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                double probability = (double) frequencies[i] / totalCharacters;
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }
        }
        return entropy;
    }
}
