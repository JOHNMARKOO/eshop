package eshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Customer extends User {
    private String address;
    private List<Item> shoppingCart;

    public Customer(int userID, String name, String password, String address) {
        super(userID, name, password);
        this.address = address;
        this.shoppingCart = new ArrayList<>();
    }

    public String getAddress() {
        return address;
    }

    public List<Item> getShoppingCart() {
        return shoppingCart;
    }

    public void addToCart(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            shoppingCart.add(item);
        }
    }

    public void removeFromCart(Item item) {
        shoppingCart.remove(item);
    }

    public void clearCart() {
        shoppingCart.clear();
    }

    public double checkout() {
        double total = 0;
        Map<Item, Integer> itemSummary = new HashMap<>();
        for (Item item : shoppingCart) {
            total += item.getPrice();
            itemSummary.put(item, itemSummary.getOrDefault(item, 0) + 1);
        }
        clearCart();

        StringBuilder invoice = new StringBuilder();
        invoice.append("Invoice\n");
        invoice.append("Customer: ").append(getName()).append("\n");
        invoice.append("Address: ").append(getAddress()).append("\n");
        invoice.append("Date: ").append(java.time.LocalDate.now()).append("\n");
        invoice.append("\nItems Purchased:\n");
        for (Map.Entry<Item, Integer> entry : itemSummary.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            invoice.append(String.format("%-20s %-10d $%.2f\n", item.getDescription(), quantity, item.getPrice() * quantity));
            
            item.setInventory(item.getInventory() - quantity);
        }
        invoice.append("\nTotal Price: $").append(String.format("%.2f", total)).append("\n");

        System.out.println(invoice.toString());

        return total;
    }
    
    public void updateCart(Item item, int quantity) {
        if (shoppingCart.contains(item)) {
            while (shoppingCart.remove(item));
            for (int i = 0; i < quantity; i++) {
                shoppingCart.add(item);
            }
        } else {
            for (int i = 0; i < quantity; i++) {
                shoppingCart.add(item);
            }
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", shoppingCart=" + shoppingCart +
                "} " + super.toString();
    }
}
