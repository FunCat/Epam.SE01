package com.epam.javase.units.unit2.t03_04;

import java.awt.*;

abstract public class Pen extends Stationery {
    private Color color;
    private float width;
    private String firm;

    public Pen(float price, String name, Color color, float width, String firm) {
        super(price, name);
        this.color = color;
        this.width = width;
        this.firm = firm;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }
}
