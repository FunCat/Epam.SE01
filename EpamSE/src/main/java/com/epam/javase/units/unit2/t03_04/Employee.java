package com.epam.javase.units.unit2.t03_04;

public class Employee {
    private String name;
    private String lastname;

    private Goods listGoods;

    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        listGoods = new Goods();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Goods getListGoods() {
        return listGoods;
    }

    public void setListGoods(Goods listGoods) {
        this.listGoods = listGoods;
    }

    @Override
    public String toString() {
        return name + " " + lastname;
    }
}
