package com.kinandcarta.exercise;

import com.kinandcarta.domain.Item;

import java.util.ArrayList;
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

    // We want to define the kinds of things a user can purchase.  So add a field here that lets us look
    // up an Item based on the item id (a String).  You'll probably want to use one of the Java collection
    // classes (https://www.javatpoint.com/collections-in-java) to make a mapping (hint, hint) between
    // the item id String and an Item instance.  It should have the word 'private' in front of it, as we
    // don't want this field to be visible from other classes.

    private HashMap<String, Item> allItems = new HashMap<String, Item>();

    // Create another field that will hold the scanned item ids (i.e. the basket).  This should be private
    // as well.

    private List<String> basket = new ArrayList<>();

    @Override
    public void scan(List<String> itemIds) {

        // Loop through the list of itemIds.  Then, for each item id:

        // 1. Verify the item id is one that we know about (i.e. check it against the field that defines item types).
        // If it's not, throw a new RuntimeException.

        // 2. Add the item id to the list of scanned items.  We'll compute the total later when requested.
        for (String item : itemIds) {
            if (allItems.get(item) != null) {
                basket.add(item);
            } else {
                throw new RuntimeException("Cannot recognise Item ID");
            }
        }
        // As the return type of the method is 'void', there's no need to return anything.
    }

    @Override
    public int getTotal() {

        // Initially items are just defined as some number of pence, an int.  So our total can be an int as well.
        int total = 0;

        // Loop through the scanned item ids.
        // For each one, look up its price and add it to the total.

        // At a later point we'll want to apply the discounts at this point, but you can skip this for now.

        // Finally, return the total.
        return total;
    }
}
