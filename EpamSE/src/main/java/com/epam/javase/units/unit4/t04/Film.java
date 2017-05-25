package com.epam.javase.units.unit4.t04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Film implements Serializable {
    private String name;
    private int yearRelease;
    private String country;
    private List<Actor> listActors;

    public Film(String name, int yearRelease, String country) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.country = country;
        this.listActors = new ArrayList<>();
    }

    public Film(String name, int yearRelease, String country, List<Actor> listActors) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.country = country;
        this.listActors = listActors;
    }

    public void addActor(Actor actor){
        listActors.add(actor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        if (yearRelease != film.yearRelease) return false;
        if (name != null ? !name.equals(film.name) : film.name != null) return false;
        if (country != null ? !country.equals(film.country) : film.country != null) return false;
        return listActors != null ? listActors.equals(film.listActors) : film.listActors == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + yearRelease;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (listActors != null ? listActors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String res = "\nFilm '" + name +
                "'\n\tyearRelease=" + yearRelease +
                "\n\tcountry='" + country + '\'' +
                "\n\tActors:";
        for (Actor actor : listActors) {
            res += "\n\t\t" + actor;
        }
        return res;
    }
}
