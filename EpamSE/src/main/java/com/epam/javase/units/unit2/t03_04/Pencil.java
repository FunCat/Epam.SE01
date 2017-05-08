package com.epam.javase.units.unit2.t03_04;

abstract public class Pencil extends Stationery{
    enum typeShape{TRIANGULAR, HEXAGONAL, ROUND, BENDABLE};

    private float diameter;
    private typeShape shape;
    private String firm;

    public Pencil(float price, String name, float diameter, typeShape shape, String firm) {
        super(price, name);
        this.diameter = diameter;
        this.shape = shape;
        this.firm = firm;
    }

    public typeShape getShape() {
        return shape;
    }

    public void setShape(typeShape shape) {
        this.shape = shape;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public float getDiameter() {
        return diameter;
    }

    public void setDiameter(float diameter) {
        this.diameter = diameter;
    }
}
