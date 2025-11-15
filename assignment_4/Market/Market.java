package assignment_4.Market;

import assignment_4.Item.Item;

import java.util.List;
import java.util.Random;

public class Market {
    private final Random random = new Random();
    private final List<Item> items;

    public Market() {
        items = MarketItemTemplates.generateRandomInventory(random, 10); // generate 10 random items
    }

    public List<Item> getItems() {
        return items;
    }

}
