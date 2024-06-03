package eshop;

import java.util.Date;

public class Event {
    private Date date;
    private Item item;
    private int quantity;
    private User user;

    public Event(Date date, Item item, int quantity, User user) {
        this.date = date;
        this.item = item;
        this.quantity = quantity;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Event{" +
                "date=" + date +
                ", item=" + item +
                ", quantity=" + quantity +
                ", user=" + user +
                '}';
    }
}
