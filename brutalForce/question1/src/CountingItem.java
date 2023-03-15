package brutalForce.question1.src;

import brutalForce.question1.src.data.Item;

public class CountingItem {
    private int quantity = 1;
    private Item item;

    public CountingItem() {
        super();
    }

    public CountingItem(Item item) {
        this.item = item;
    }

    public CountingItem(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public static CountingItem FromAnotherCountingItem(
        CountingItem countingItem
    ) {
        return new CountingItem(
            countingItem.getQuantity(), countingItem.getItem() 
        );
    }

    public void printData() {
        System.out.println("Nome: " + item.getName());
        System.out.println("Valor: " + item.getValue());
        System.out.println("Peso: " + item.getWeight());
        System.out.println("Quantidade: " + quantity);
        System.out.println();
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
