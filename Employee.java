package eshop;

import java.util.List;

public class Employee extends User {

    public Employee(int userID, String name, String password) {
        super(userID, name, password);
    }

    public void addItem(List<Item> items, int itemNumber, String description, int inventory, double price) {
        items.add(new Item(itemNumber, description, inventory, price));
    }

    public void updateInventory(Item item, int newInventory) {
        item.setInventory(newInventory);
    }

    @Override
    public String toString() {
        return "Employee{} " + super.toString();
    }
}
