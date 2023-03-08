package src;

import src.data.Item;

public class CountingItem {
    private int quantity;
    private Item item;

    public CountingItem() {
        super();
    }

    public CountingItem(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
