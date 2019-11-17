package com.ptit.restaurantmanagement.domain.model;

import java.util.Calendar;
import java.util.HashMap;

public class Invoice {
    private int invoiceId;
    private int customerId;
    private int employeeId;
    private Calendar creationTime;
    private HashMap<MenuEntry, Integer> invoiceEntries = new HashMap<>();

    public Invoice(int invoiceId, int customerId, int employeeId, Calendar creationTime) {
        this.invoiceId = invoiceId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.creationTime = creationTime;

        if (creationTime == null) {
            this.creationTime = Calendar.getInstance();
        }
    }

    public Invoice(int customerId, int employeeId, Calendar creationTime) {
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.creationTime = creationTime;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Calendar getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Calendar creationTime) {
        this.creationTime = creationTime;
    }

    public HashMap<MenuEntry, Integer> getInvoiceEntries() {
        return invoiceEntries;
    }

    public void addEntry(int menuEntryId, int quantity) {
        //TODO
    }

    public void setEntryQuantity(int menuEntryId, int quantity) {
        //TODO
    }

    public void deleteEntry(int menuEntryId) {
        //TODO
    }


    public int getEntriesCount() {
        //TODO: Test
        return invoiceEntries.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public double getTotalAmount() {
        //TODO: Test
        double total = 0.0;

        for (MenuEntry menuEntry : invoiceEntries.keySet()) {
            total += menuEntry.getPrice() * invoiceEntries.get(menuEntry);
        }

        return total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", creationTime=" + creationTime +
                ", invoiceEntries=" + invoiceEntries +
                '}';
    }
  
    public Object[] toObjects(){
        return new Object[]{
            invoiceId, customerId , employeeId , creationTime , invoiceEntries
        };
    }
}
