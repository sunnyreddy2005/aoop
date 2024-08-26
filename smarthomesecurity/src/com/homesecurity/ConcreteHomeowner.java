package com.homesecurity;

import java.util.ArrayList;
import java.util.List;

public class ConcreteHomeowner implements Homeowner {
    private String name;
    private List<String> notifications = new ArrayList<>();

    public ConcreteHomeowner(String name) {
        this.name = name;
    }

    public void update(String eventType, String eventMessage) {
        String notification = name + " received notification: [" + eventType + "] " + eventMessage;
        notifications.add(notification);
        System.out.println(notification);
    }

    public List<String> getNotifications() {
        return notifications;
    }
}
