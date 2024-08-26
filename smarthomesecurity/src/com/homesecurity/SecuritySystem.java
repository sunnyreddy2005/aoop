package com.homesecurity;

public interface SecuritySystem {
    void registerHomeowner(Homeowner homeowner);
    void removeHomeowner(Homeowner homeowner);
    void notifyHomeowners(String eventType, String eventMessage);
}
