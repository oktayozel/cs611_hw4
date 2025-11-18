package assignment_4.Market;

import assignment_4.Core.User;
import assignment_4.Hero.Hero;
import assignment_4.Item.Item;
import assignment_4.Inventory.InventoryEntry;
import assignment_4.Inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import IO.Input;
import IO.Output;


public class Market {
    private final Random random = new Random();
    private final List<Item> items;              // primary stock
    private final List<Item> secondHandItems;    // items sold by heroes

    public Market() {
        items = MarketItemTemplates.generateRandomInventory(random, 10); // generate 10 random items
        secondHandItems = new ArrayList<>();
    }

    public List<Item> getItems() { return items; }
    public List<Item> getSecondHandItems() { return secondHandItems; }


    // buy item
    public boolean buyItem(Hero hero, Item item) {
        if (hero == null || item == null) return false;
        if (hero.getLevel() < item.getLevel()) {
            Output.print("Hero level too low for this item.\n");
            return false;
        }
        if (!hero.spendGold(item.getPrice())) {
            Output.print("Not enough gold.\n");
            return false;
        }
        // Add to hero inventory
        
        hero.getInventory().addItem(item, 1);

        Output.print("Purchased: " + item.getName() + "\n");
        return true;
    }



    // sell item from heros inventory
    public boolean sellItem(Hero hero, String itemName) {
        if (hero == null || itemName == null || itemName.isEmpty()) return false;
        InventoryEntry entry = hero.getInventory().getEntryByName(itemName);
        if (entry == null) {
            Output.print("Item not found in inventory.\n");
            return false;
        }
        Item item = entry.getItem();
        int sellPrice = item.getPrice() / 2;
        hero.addGold(sellPrice);
        // Decrease quantity or remove
        if (entry.getQuantity() > 1) {
            entry.decreaseQuantity(1);
        } else {
            hero.getInventory().removeItemByName(itemName);
        }
        // Add to second-hand stock (a copy reference; treat each sale as single unit)
        secondHandItems.add(item);
        Output.print("Sold: " + item.getName() + " for " + sellPrice + " gold.\n");
        return true;
    }

    // market loop
    public void start(User user) {
        if (user == null) return;
        user.setInMarket(true);
        boolean running = true;
        while (running) {
            Output.displayMarket(this);
            Output.printMarketMenu();
            running = Input.getMarketInput(this, user);
        }
        user.setInMarket(false);
    }
}
