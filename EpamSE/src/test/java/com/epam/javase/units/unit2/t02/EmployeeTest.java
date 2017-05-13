package com.epam.javase.units.unit2.t02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee employee;
    Pen p1;
    Pen p2;
    Pencil pencil1;


    @Before
    public  void initialize(){
        employee = new Employee("Sergey", "Petorv");
        p1 = new Pen(12.5f, Color.BLACK, 2);
        p2 = new Pen(15.5f, Color.BLUE, 1);
        pencil1 = new Pencil(13.4f, 1, "HB");
    }

    @Test
    public void addThing() throws Exception {
        employee.addThing(p1);
        Assert.assertEquals(1, employee.getListStationery().size());
        Assert.assertEquals(p1, employee.getListStationery().get(0));

        employee.addThing(pencil1);
        Assert.assertEquals(2, employee.getListStationery().size());
        Assert.assertEquals(p1, employee.getListStationery().get(0));
        Assert.assertEquals(pencil1, employee.getListStationery().get(1));

        employee.addThing(null);
        Assert.assertEquals(2, employee.getListStationery().size());
        Assert.assertEquals(p1, employee.getListStationery().get(0));
        Assert.assertEquals(pencil1, employee.getListStationery().get(1));

        employee.addThing(p2);
        Assert.assertEquals(3, employee.getListStationery().size());
        Assert.assertEquals(p1, employee.getListStationery().get(0));
        Assert.assertEquals(pencil1, employee.getListStationery().get(1));
        Assert.assertEquals(p2, employee.getListStationery().get(2));

    }

    @Test
    public void getTotalPrice() throws Exception {
        employee.addThing(p1);
        float res = employee.getTotalPrice();
        float expected = p1.getPrice();
        Assert.assertEquals(expected, res, 0.0001);

        employee.addThing(pencil1);
        res = employee.getTotalPrice();
        expected = p1.getPrice() + pencil1.getPrice();
        Assert.assertEquals(expected, res, 0.0001);

        employee.addThing(null);
        res = employee.getTotalPrice();
        expected = p1.getPrice() + pencil1.getPrice();
        Assert.assertEquals(expected, res, 0.0001);

        employee.addThing(p2);
        res = employee.getTotalPrice();
        expected = p1.getPrice() + pencil1.getPrice() + p2.getPrice();
        Assert.assertEquals(expected, res, 0.0001);

    }

}