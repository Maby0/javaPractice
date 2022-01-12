package com.kinandcarta.exercise;

import com.kinandcarta.domain.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CheckoutImpl implements Checkout {
    private static HashMap<String, Item> allItems = new HashMap<String, Item>(){{
        put("0001", new Item("0001", "Water Bottle", 2495));
        put("0002", new Item("0002", "Hoodie", 6500));
        put("0003", new Item("0003", "Sticker Set", 399));
    }};
    private List<String> basket = new ArrayList<>();
    private int total;

    @Override
    public void scan(List<String> itemIds) {
        for (String item : itemIds) {
            if (allItems.get(item) != null) {
                basket.add(item);
            } else {
                throw new RuntimeException("Cannot recognise Item ID");
            }
        }
    }

    @Override
    public int getTotal() {
        if (total > 0 || this.basket.isEmpty()) return total;

        total = basket.stream()
                .mapToInt(itemId -> allItems.get(itemId).getPrice())
                .sum();

        WaterBottlesPromo waterBottles = new WaterBottlesPromo(total, basket);
        if (waterBottles.checkForPromotion()) total = waterBottles.applyPromotion();

        Over75Promo over75 = new Over75Promo(total);
        if (over75.checkForPromotion()) total = over75.applyPromotion();

        return total;
    }
}
