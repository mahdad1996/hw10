package com.HW08.maktab32.util;

import com.HW08.maktab32.entities.Address;

import javax.persistence.Column;

public class AddressBuilder {
    private String provience;

    private String city;

    private String street;

    private String postCode;

    public AddressBuilder provience(String provience) {
        this.provience = provience;
        return this;
    }

    public AddressBuilder city(String city) {
        this.city = city;
        return this;
    }

    public AddressBuilder street(String street) {
        this.street = street;
        return this;
    }

    public AddressBuilder postCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public Address build(){
        Address address = new Address();
        address.setCity(city);
        address.setProvience(provience);
        address.setStreet(street);
        address.setPostCode(postCode);
        return address;
    }
}
