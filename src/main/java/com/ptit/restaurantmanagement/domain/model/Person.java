package com.ptit.restaurantmanagement.domain.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Person {
    private Integer id; //nullable
    private String name;
    private Calendar dob; //nullable
    private String address; //nullable
    private ArrayList<String> phoneNumbers = new ArrayList<>();

    public Person(Integer id, String name, Calendar dob, String address) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public Person(String name, Calendar dob, String address) {
        this.name = name;
        this.dob = dob;
        this.address = address;
    }

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear = dob.get(Calendar.YEAR);

        return currentYear - birthYear;
    }

    public Calendar getDob() {
        return dob;
    }

    public void setDob(Calendar dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //TODO: Test phone number feature

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void updatePhoneNumber(String newPhoneNumber, String oldPhoneNumber) {
        int oldPhoneNumberIndex = phoneNumbers.indexOf(oldPhoneNumber);
        phoneNumbers.set(oldPhoneNumberIndex, newPhoneNumber);
    }

    public void removePhoneNumber(String phoneNumber) {
        phoneNumbers.remove(phoneNumber);
    }
}
