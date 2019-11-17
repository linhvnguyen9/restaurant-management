package com.ptit.restaurantmanagement.domain.model;

public class Line {
    private int invoiceId;
    private int entryId;
    private int quantity;

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getEntryId() {
        return entryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Line(int invoiceId, int entryId, int quantity) {
        this.invoiceId = invoiceId;
        this.entryId = entryId;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Line{" +
                "invoiceId=" + invoiceId +
                ", entryId=" + entryId +
                ", quantity=" + quantity +
                '}';
    }
}
