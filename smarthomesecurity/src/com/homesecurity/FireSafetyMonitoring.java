package com.homesecurity;

public class FireSafetyMonitoring extends SecurityMonitoringTemplate {

    @Override
    protected void prepareMonitoring() {
        System.out.println("Preparing for fire safety monitoring...");
    }

    @Override
    protected void executeMonitoring() {
        System.out.println("Monitoring for fire safety...");
        System.out.println("Fire alarm triggered!");
    }
}
