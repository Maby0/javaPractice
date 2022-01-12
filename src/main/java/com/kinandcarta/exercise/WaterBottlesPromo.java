package com.kinandcarta.exercise;

import java.util.Collections;
import java.util.List;

public class WaterBottlesPromo implements PromotionInterface {
    private int basketTotal;
    private List<String> basketContents;
    private int nWaterBottles;

    public WaterBottlesPromo(int basketTotal, List<String> items) {
        this.basketTotal = basketTotal;
        this.basketContents = items;
        this.nWaterBottles = Collections.frequency(basketContents, "0001");
    }

    @Override
    public boolean checkForPromotion() {
        return Collections.frequency(basketContents, "0001") >= 2;
    }

    @Override
    public int applyPromotion() {
        int eachBottleDiscounted = 2495 - 2299;
        return basketTotal - (nWaterBottles * eachBottleDiscounted);
    }
}
