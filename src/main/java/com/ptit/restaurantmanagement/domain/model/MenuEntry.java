package com.ptit.restaurantmanagement.domain.model;

import jdk.nashorn.internal.runtime.Debug;

public class MenuEntry {
    private int entryId;
    private String name;
    private double price;

    public MenuEntry(int entryId, String name, double price) {
        this.entryId = entryId;
        this.name = name;
        this.price = price;
    }

    public MenuEntry(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Object[] toObjects(){
        return new Object[]{
            entryId, name, price
        };
    }
}
