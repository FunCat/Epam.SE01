package com.epam.javase.units.unit4.t04;

import java.io.Serializable;

public class Actor implements Serializable {
    private String name;
    private String lastname;
    private int year;

    public Actor(String name, String lastname, int year) {
        this.name = name;
        this.lastname = lastname;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Actor actor = (Actor) o;

        if (year != actor.year) return false;
        if (name != null ? !name.equals(actor.name) : actor.name != null) return false;
        return lastname != null ? lastname.equals(actor.lastname) : actor.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return name + " " + lastname + " " + year;
    }
}
