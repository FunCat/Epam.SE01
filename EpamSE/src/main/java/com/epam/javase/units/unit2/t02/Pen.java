package com.epam.javase.units.unit2.t02;

import java.awt.*;

public class Pen extends Stationery {
    private Color color;
    private int width;

    public Pen(float price, Color color, int width) {
        super(price);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Pen\n\tprice\t\t" + getPrice() +
                "\n\tcolor\t\tR=" + color.getRed() +
                "; G=" + color.getGreen() +
                "; B=" + color.getBlue() +
                "\n\twidth\t\t" + width;
    }
}
