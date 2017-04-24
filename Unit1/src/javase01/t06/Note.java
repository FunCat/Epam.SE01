package javase01.t06;

public class Note {

    public Note(String text, int index) {
        this.text = text;
        this.id = index;
    }

    public int getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
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
        return "Note " + id + "\n\t\"" + text + '\"';
    }

    private String text = "-";
    private int id;
}
