package com.epam.javase.units.unit2.t5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Discipline {
    private String name;
    private Map<Student, Float> listStudents = new HashMap<Student, Float>();
    private boolean isInt;

    public Discipline(String name, boolean isInt) {
        this.name = name;
        listStudents = new HashMap<Student, Float>();
        this.isInt = isInt;
    }

    /** Generate a random mark from 2 to 5*/
    public float generateMark(){
        return (isInt)?((int)(Math.random() * 3 + 2)):((float)(Math.random() * 3 + 2));
    }

    /** Add a student in the discipline map */
    public void addNewStudentForDiscipline(Student student){
        listStudents.put(student, generateMark());
    }

    /** Find a maxValue from all selected maps, if a student doesn't contain in anywhere maps return 0 */
    public float findStudentInDiscipline(Student student, Map<Student, Float>... listesStudents){
        float maxValue = 0;
        for(int i = 0; i < listesStudents.length; i++) {
            if (listesStudents[i].containsKey(student)) {
                if(maxValue < listesStudents[i].get(student)) maxValue = listesStudents[i].get(student);
            }
        }
        return maxValue;
    }

    @Override
    public String toString() {
        String text = "Discipline " + name + "\n";
        for(Map.Entry<Student, Float> student : listStudents.entrySet()){
            text += "\t" + student.getKey() + " " + String.format("%.2f",student.getValue()) + "\n";
        }
        return text;
    }

    public static void main(String[] args) {
        Student st1 = new Student("Sergey", "Petrov", 1996);
        Student st2 = new Student("Maksim", "Andreev", 1994);
        Student st3 = new Student("Vitalii", "Bektimirov", 1995);
        Student st4 = new Student("Vicheslav", "Beristov", 1997);
        Student st5 = new Student("Stepan", "Gavrilov", 1996);
        Student st6 = new Student("Maksim", "Gorbachov", 1997);
        Student st7 = new Student("Sergey", "Sverev", 1995);

        Discipline math = new Discipline("Math", false);
        math.addNewStudentForDiscipline(st1);
        math.addNewStudentForDiscipline(st3);
        System.out.println(math);

    }



}
