package com.epam.javase.units.unit4.t04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationClasses {

    public static void main(String[] args) {
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

        serializeFilms(listFilm);
        try {
            List<Film> listFilm2 = deserializeFilms();
            System.out.println(listFilm2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /** Serialize the list of films */
    public static void serializeFilms(List<Film> listFilm){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.data"))){
            oos.writeObject(listFilm);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    /** Deserialize the list of films */
    public static List<Film> deserializeFilms() throws ClassNotFoundException {
        List<Film> newListFilm = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.data"))){
            newListFilm = (ArrayList<Film>) ois.readObject();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return newListFilm;
    }
}
