package com.epam.javase.units.unit2.t02;

public class Pencil extends Stationery{
    private int width;
    private String softness;

    public Pencil(float price, int width, String softness) {
        super(price);
        this.width = width;
        this.softness = softness;
    }

    @Override
    public String toString() {
        return "Pencil\n\tprice\t\t" + getPrice() +
                "\n\twidth\t\t" + width +
                "\n\tsoftness\t" + softness;
    }
}
