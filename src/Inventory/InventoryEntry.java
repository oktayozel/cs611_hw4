package src.Inventory;
import src.Item.Item;



// holds a single item in inventory
public class InventoryEntry {

    private Item item;
    private int quantity;

    // constructor for inventory entry
    public InventoryEntry(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    // return item
    public Item getItem() {
        return item;
    }

    // set item
    public void setItem(Item item) {
        this.item = item;
    }

    // return quantity
    public int getQuantity() {
        return quantity;
    }

    // set quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // increase quantity
    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

    // decrease quantity
    public void decreaseQuantity(int amount) {
        this.quantity -= amount;
    }

    @Override
    public String toString() {
        return "InventoryEntry{" +
                "item=" + item +
                ", quantity=" + quantity +
                '}';
    }
}
