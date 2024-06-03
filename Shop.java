package eshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    private Map<Integer, User> users;
    private List<Item> items;
    private List<Event> events;
    private int userIDCounter;
    private int NextItemNumber;

    public Shop() {
        this.users = new HashMap<>();
        this.items = new ArrayList<>();
        this.events = new ArrayList<>();
        this.userIDCounter = 3;  
        this.NextItemNumber = 6;  
    }

    public void registerCustomer(int userID, String name, String password, String address) {
        users.put(userID, new Customer(userID, name, password, address));
    }

    public void registerEmployee(int userID, String name, String password) {
        users.put(userID, new Employee(userID, name, password));
    }

    public User login(int userID, String password) {
        User user = users.get(userID);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    public List<Item> getItems() {
        return items;
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public Item findItemByNumber(int itemNumber) {
        for (Item item : items) {
            if (item.getItemNumber() == itemNumber) {
                return item;
            }
        }
        return null;
    }
    
    public void addItem(int itemNumber, String description, int inventory, double price) {
        items.add(new Item(itemNumber, description, inventory, price));
    }

    public int generateUserID() {
        return userIDCounter++;
    }

    public void recordEvent(Event event) {
        events.add(event);
    }
    
    public int getNextItemNumber() {
        return NextItemNumber;
    }
}
