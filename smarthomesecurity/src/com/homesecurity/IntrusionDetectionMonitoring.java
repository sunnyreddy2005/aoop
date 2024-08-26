package com.homesecurity;

public class IntrusionDetectionMonitoring extends SecurityMonitoringTemplate {

    @Override
    protected void prepareMonitoring() {
        System.out.println("Preparing for intrusion detection...");
    }

    @Override
    protected void executeMonitoring() {
        System.out.println("Monitoring for intrusion...");
        System.out.println("Intrusion detected!");
    }
}
