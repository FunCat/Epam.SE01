package com.epam.javase.units.unit2.t5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Discipline {
    String name;
    Map<Student, Integer> listStudents = new HashMap<Student, Integer>();

    public Discipline(String name) {
        this.name = name;
        listStudents = new HashMap<Student, Integer>();
    }

    /** Generate a random mark from 2 to 5*/
    public int generateMark(){
        return (int)(Math.random() * 3 + 2);
    }

    /** Add a student in the discipline map */
    public void addNewStudentForDiscipline(Student student){
        listStudents.put(student, generateMark());
    }

    @Override
    public String toString() {
        String text = "Discipline " + name + "\n";
        for(Map.Entry<Student, Integer> student : listStudents.entrySet()){
            text += "\t" + student.getKey() + " " + student.getValue() + "\n";
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

        Discipline math = new Discipline("Math");
        math.addNewStudentForDiscipline(st1);
        math.addNewStudentForDiscipline(st3);
        System.out.println(math);

    }

    public void findStudentInDiscipline(){

    }

}
