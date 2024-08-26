package com.homesecurity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmartHomeSecuritySystemTest {

    @Test
    public void testHomeownerNotification() {
        
        SmartHomeSecuritySystem securitySystem = new SmartHomeSecuritySystem();

        
        ConcreteHomeowner homeowner1 = new ConcreteHomeowner("Sunny");
        ConcreteHomeowner homeowner2 = new ConcreteHomeowner("Sai");

        
        securitySystem.registerHomeowner(homeowner1);
        securitySystem.registerHomeowner(homeowner2);

       
        securitySystem.notifyHomeowners("Intrusion", "Intruder detected in the living room");

       
        assertEquals(1, homeowner1.getNotifications().size());
        assertEquals("Sunny received notification: [Intrusion] Intruder detected in the living room", homeowner1.getNotifications().get(0));

        assertEquals(1, homeowner2.getNotifications().size());
        assertEquals("Sai received notification: [Intrusion] Intruder detected in the living room", homeowner2.getNotifications().get(0));
    }

    @Test
    public void testIntrusionDetectionMonitoring() {
        
        SecurityMonitoringTemplate intrusionMonitoring = new IntrusionDetectionMonitoring();
        intrusionMonitoring.monitor();

    }

    @Test
    public void testFireSafetyMonitoring() {
        
        SecurityMonitoringTemplate fireSafetyMonitoring = new FireSafetyMonitoring();
        fireSafetyMonitoring.monitor();

        
    }
}
