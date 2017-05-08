package com.epam.javase.units.unit1.t06;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Note {

    public Note(String text, int index) {
        this.text = text;
        this.id = index;
        dateNote = Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateNote(Calendar dateNote) {
        this.dateNote = dateNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (id != note.id) return false;
        return text != null ? text.equals(note.text) : note.text == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return "Note " + id + "   " + dateFormat.format(dateNote.getTime()) + "\n\t\"" + text + '\"';
    }

    private String text = "-";
    private int id;
    private Calendar dateNote;
}
