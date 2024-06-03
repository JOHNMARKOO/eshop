package eshop;

public class Item {
    private int itemNumber;
    private String description;
    private int inventory;
    private double price;

    public Item(int itemNumber, String description, int inventory, double price) {
        this.itemNumber = itemNumber;
        this.description = description;
        this.inventory = inventory;
        this.price = price;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemNumber=" + itemNumber +
                ", description='" + description + '\'' +
                ", inventory=" + inventory +
                ", price=" + price +
                '}';
    }
}
