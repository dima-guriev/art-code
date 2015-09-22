package com.artcode.task1.entity;

/**
 * Created by dimasik on 21.09.15.
 */
public class Address {
    private String country;
    private String city;
    private String street;
    private int building;

    public Address(String country, String city, String street, int building) {
        this.country = country;
        this.city = city;
        this.street = street;
        setBuilding(building);
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    @Override
    public String toString() {
        return getCountry() + ". " + getCity() + ", " + getCity() + " " + getBuilding();
    }
}
