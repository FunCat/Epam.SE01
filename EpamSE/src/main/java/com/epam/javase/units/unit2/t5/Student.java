package com.epam.javase.units.unit2.t5;

public class Student {
    String name;
    String lastname;
    int year;


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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Student(String name, String lastname, int year) {
        this.name = name;
        this.lastname = lastname;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + " " + lastname;
    }

}
