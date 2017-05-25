package com.epam.javase.units.unit4.t04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Сергей on 25.05.2017.
 */
public class SerializationClassesTest {

    @Test
    public void deserializeFilms() throws Exception {
        List<Film> listFilm = new ArrayList<>();
        List<Actor> actorList = new ArrayList<>();
        actorList.add(new Actor("Johnny", "Depp", 1963));
        actorList.add(new Actor("Orlando", "Bloom", 1977));
        actorList.add(new Actor("Keira", "Knightley", 1985));
        listFilm.add(new Film("Pirates of the Caribbean: Dead Men Tell No Tales", 2017, "USA", actorList));
        List<Actor> actorList2 = new ArrayList<>();
        actorList2.add(new Actor("Michael", "Fassbender", 1977));
        actorList2.add(new Actor("Katherine", "Waterston", 1980));
        actorList2.add(new Actor("Danny ", "McBride", 1976));
        listFilm.add(new Film("Alien: Covenant", 2017, "USA, UK, Australia, New Zealand", actorList2));

        SerializationClasses.serializeFilms(listFilm);
        List<Film> listFilm2 = null;
        try {
            listFilm2 = SerializationClasses.deserializeFilms();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(listFilm, listFilm2);
    }

    @Test
    public void deserializeFilmsNull() throws Exception {
        List<Film> listFilm = null;
        SerializationClasses.serializeFilms(listFilm);
        List<Film> listFilm2 = null;
        try {
            listFilm2 = SerializationClasses.deserializeFilms();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(listFilm, listFilm2);
    }
}