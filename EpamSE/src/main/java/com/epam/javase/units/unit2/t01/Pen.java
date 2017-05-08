package com.epam.javase.units.unit2.t01;

import java.awt.*;

public class Pen {
    Color color;
    int width;

    public Pen(Color color, int width) {
        this.color = color;
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color={R=" + color.getRed() +
                "; G=" + color.getGreen() +
                "; B=" + color.getBlue() +
                "}, width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (width != pen.width) return false;
        return color != null ? color.equals(pen.color) : pen.color == null;
    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + width;
        return result;
    }

    public static void main(String[] args) {
        Pen p1 = new Pen(Color.white, 2);
        System.out.println(p1);
    }
}
