package com.homesecurity;

import java.util.ArrayList;
import java.util.List;

public class SmartHomeSecuritySystem implements SecuritySystem {
    private List<Homeowner> homeowners = new ArrayList<>();

    @Override
    public void registerHomeowner(Homeowner homeowner) {
        homeowners.add(homeowner);
    }

    @Override
    public void removeHomeowner(Homeowner homeowner) {
        homeowners.remove(homeowner);
    }

    @Override
    public void notifyHomeowners(String eventType, String eventMessage) {
        for (Homeowner homeowner : homeowners) {
            homeowner.update(eventType, eventMessage);
        }
    }
}
