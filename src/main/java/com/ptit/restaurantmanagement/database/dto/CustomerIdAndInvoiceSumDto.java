package com.ptit.restaurantmanagement.database.dto;

public class CustomerIdAndInvoiceSumDto {
    private int customerId;
    private String customerName;
    private int sum;

    public CustomerIdAndInvoiceSumDto(int customerId, String customerName, int sum) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.sum = sum;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "CustomerIdAndInvoiceSumDto{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", sum=" + sum +
                '}';
    }

    public Object[] toObject() {
        return new Object[]{
                customerId, customerName, sum
        };
    }
}
