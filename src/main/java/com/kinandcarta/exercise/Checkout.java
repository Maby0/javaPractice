package com.kinandcarta.exercise;

import java.util.List;


public interface Checkout {
    void scan(List<String> itemIds);
    int getTotal();
}
