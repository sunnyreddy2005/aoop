package com.homesecurity;

public abstract class SecurityMonitoringTemplate {

    public final void monitor() {
        prepareMonitoring();
        executeMonitoring();
        reportStatus();
    }

    protected abstract void prepareMonitoring();

    protected abstract void executeMonitoring();

    protected void reportStatus() {
        System.out.println("Security monitoring process completed.");
    }
}
