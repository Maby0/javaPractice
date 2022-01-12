package com.kinandcarta.exercise;

import com.kinandcarta.domain.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * The default implementation of a {@link Checkout}.  This means that all the methods defined in
 * Checkout MUST be implemented here.  There are skeleton implementations for these methods below.
 *
 * (This class could also implement other interfaces as well, but do not confuse this with 'multiple
 * inheritance' that you may know from C++ or other languages; Java only allows single inheritance.)
 */
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
