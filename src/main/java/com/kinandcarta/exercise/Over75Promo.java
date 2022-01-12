package com.kinandcarta.exercise;

import java.util.List;
import java.lang.Integer;

public class Over75Promo implements PromotionInterface {

    private int basketTotal;
    public Over75Promo(int basketTotal) {
        this.basketTotal = basketTotal;
    }

    @Override
    public boolean checkForPromotion() {
        return basketTotal > 7500;
    }

    @Override
    public int applyPromotion() {
        return (int) Math.round((float) basketTotal * 0.9);
    }
}
