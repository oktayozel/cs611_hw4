package src.Inventory;
import src.Item.Item;

public class InventoryEntry {

    private Item item;
    private int quantity;

    public InventoryEntry(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

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
