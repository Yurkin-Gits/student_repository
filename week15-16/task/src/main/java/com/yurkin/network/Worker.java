package com.yurkin.network;

import java.util.List;

import com.yurkin.model.HousePriceRecord;
import com.yurkin.model.Task;

public interface Worker {
    List<HousePriceRecord> process(Task task);
}