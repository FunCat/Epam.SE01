package javase01.t06;

public class Notepad {

    public Notepad(String nameNotepad) {
        this.nameNotepad = nameNotepad;
        this.listNotes = new Note[10];
    }

    public String getNameNotepad() {
        return nameNotepad;
    }

    private String nameNotepad;
    private Note[] listNotes;
    /** Номер следующей записи в блокноте */
    private static int index = 1;
    /** Количество записей в блокноте */
    private static int countNotes = 0;


    public static void main(String[] args) {
        Notepad myNotepad = new Notepad("Diary");
        for(int i = 0; i < 15; i++)
            myNotepad.addNewNote("Hello World!");
        myNotepad.deleteNode(3);
        myNotepad.deleteNode(5);
        myNotepad.updateNote(2,"Hi!");
        myNotepad.deleteNode(12);
        myNotepad.updateNote(12,"ERROR!");

        myNotepad.watch();
    }

    /** Добавление записи в блокнот
     *  @param text
     *      Текст записи
     */
    public void addNewNote(String text){
        if(countNotes == listNotes.length) listNotes = grow();
        listNotes[countNotes] = new Note(text, Notepad.index);
        countNotes++;
        Notepad.index++;
    }

    /** Удаление записи по её номеру
     *  @param delIdNote
     *      Номер записи в блокноте
     */
    public void deleteNode(int delIdNote){
        if(delIdNote <= 0) return;
        int index = find(delIdNote);
        if(index == -1) {System.out.println("Записи с таким номером нету!"); return;}
        listNotes[index] = null;
        listNotes = compress();
    }

    /** Обновление записи по её номеру
     *  @param updIdNote
     *      Номер обновляемой записи
     *  @param newText
     *      Новый текст записи
     */
    public void updateNote(int updIdNote, String newText){
        if(updIdNote <= 0) return;
        int index = find(updIdNote);
        if(index == -1) {System.out.println("Записи с номером " + updIdNote + " нету!"); return;}
        listNotes[index].setText(newText);
    }

    /** Поиск индекса в массиве записи по её номеру
     *  @param idNote
     *      Номер записи
     *  @return
     *      Индекс массива под которым лежит запись с указанным номером
     */
    public int find(int idNote){
        int left = 0;
        int right = countNotes - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (idNote < listNotes[mid].getId()) right = mid - 1;
            else if (idNote > listNotes[mid].getId()) left = mid + 1;
            else return mid;
        }
        return -1;
    }

    /** Вывод всех записей блокнота */
    public void watch(){
        System.out.println("Notepad " + getNameNotepad());
        System.out.println();
        for(Note oneNote : listNotes){
            if(oneNote == null) continue;
            System.out.println(oneNote);
        }
    }

    /** Убирает пустые элементы массива и сдвигает все остальные к началу
     *  @return
     *      Ссылка на сжатый массив
     * */
    public Note[] compress(){
        Note[] compassListNotes = new Note[listNotes.length];
        int i = 0;
        for(Note oneNote : listNotes){
            if(oneNote == null) continue;
            compassListNotes[i] = oneNote;
            i++;
        }
        countNotes = i;
        return compassListNotes;
    }

    /** Увеличивает размер массива
     *  @return
     *      Ссылка на новый увеличенный массив
     */
    public Note[] grow(){
        Note[] newListNotes = new Note[listNotes.length + 10];
        int j = 0;
        for(j = 0; j < countNotes; j++ ){
            newListNotes[j] = listNotes[j];
        }
        countNotes = j;
        return newListNotes;
    }
}
