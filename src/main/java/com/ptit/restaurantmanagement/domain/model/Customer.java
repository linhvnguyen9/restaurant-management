package com.ptit.restaurantmanagement.domain.model;

import java.util.Calendar;

public class Customer extends Person {
    private CustomerType customerType;
    //View to select customer type should be a drop down list / checkbox

    public Customer(int id, String name, Calendar dob, String address, String phoneNumber, CustomerType customerType) {
        super(id, name, dob, address, phoneNumber);
        this.customerType = customerType;
    }

    public Customer(String name, Calendar dob, String address, String phoneNumber, CustomerType customerType) {
        super(name, dob, address, phoneNumber);
        this.customerType = customerType;
    }


    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
    public Object[] toObjects(){
        return new Object[]{
            getId(), getName(), getCustomerType(),getFormattedDob(), getAddress() ,getPhoneNumber()
        };
    }
}