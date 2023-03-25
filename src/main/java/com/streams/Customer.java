package com.streams;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    protected String id;
    protected String name;
    protected String city;
    protected int number_of_purchases;
    public enum Gender {
        FEMALE,
        MALE
    }
    private Gender gender;

    public Customer(String id, String name, String city, int number_of_purchases, Gender gender) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.number_of_purchases = number_of_purchases;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", number_of_purchases=" + number_of_purchases +
                ", gender=" + gender +
                '}';
    }
}
