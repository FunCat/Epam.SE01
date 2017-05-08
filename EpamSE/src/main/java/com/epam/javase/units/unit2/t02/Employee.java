package com.epam.javase.units.unit2.t02;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Employee {

    public Employee(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    /** Add a new thing to the eymployee */
    public void addThing(Stationery thing){
        listStationery.add(thing);
    }

    /** Write the list of all the things the employee has*/
    public void writeList(){
        System.out.println(this);
        System.out.println("================================================");
        for (Stationery thing : listStationery) {
            System.out.println(thing);
        }
        System.out.println("================================================");
    }

    /** Count the total price of all the things the employee has */
    public float getTotalPrice(){
        float res = 0.0f;
        for (Stationery stationery : listStationery) {
            res += stationery.getPrice();
        }
        return res;
    }

    /** Write the total price of all the things the employee has */
    public void writeTotalPrice(){
        System.out.println("Total price = " + this.getTotalPrice());
    }

    @Override
    public String toString() {
        return "Employee - " + lastname + " " + name;
    }

    public static void main(String[] args) {
        Employee em1 = new Employee("Sergey", "Petrov");
        em1.addThing(new Pen(15.2f, Color.BLACK, 2));
        em1.addThing(new Pen(14.8f, Color.RED, 2));
        em1.addThing(new Pencil(10.6f, 1, "HB"));
        em1.writeList();
        em1.writeTotalPrice();
    }

    private String name;
    private String lastname;
    private List<Stationery> listStationery = new ArrayList<Stationery>();
}
