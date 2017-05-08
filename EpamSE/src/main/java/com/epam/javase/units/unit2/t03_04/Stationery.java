package com.epam.javase.units.unit2.t03_04;

abstract public class Stationery {
    private float price;
    private String name;

    public Stationery(float price, String name) {
        this.price = price;
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
