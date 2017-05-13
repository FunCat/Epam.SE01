package com.epam.javase.units.unit2.t5;

import java.util.HashMap;
import java.util.Map;

public class Discipline {
    private String name;
    private Map<Student, Float> listStudents = new HashMap<>();
    private static boolean isInt = true;

    public Discipline(String name, boolean isInt) {
        this.name = name;
        listStudents = new HashMap<>();
        this.isInt = isInt;
    }

    public Map<Student, Float> getListStudents() {
        return listStudents;
    }

    /** Generate a random mark from 2 to 5*/
    public static float generateMark(){
        return (isInt)?(int)(Math.random() * 3 + 2):(float)(Math.random() * 3 + 2);
    }

    /** Add a student in the discipline map */
    public void addNewStudentForDiscipline(Student student, float mark){
        if(student == null) return;
        if(mark < 2) mark = 2;
        else if(mark > 5) mark = 5;
        listStudents.put(student, mark);
    }

    @Override
    public String toString() {
        String text = "Discipline " + name + "\n";
        for(Map.Entry<Student, Float> student : listStudents.entrySet()){
            text += "\t" + student.getKey() + " " + strFormatFloat(student.getValue()) + "\n";
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
        math.addNewStudentForDiscipline(st1, generateMark());
        math.addNewStudentForDiscipline(st5, generateMark());
        math.addNewStudentForDiscipline(st3, generateMark());
        System.out.println(math);

        Discipline english = new Discipline("English", true);
        english.addNewStudentForDiscipline(st5, generateMark());
        english.addNewStudentForDiscipline(st2, generateMark());
        english.addNewStudentForDiscipline(st6, generateMark());
        english.addNewStudentForDiscipline(st1, generateMark());
        System.out.println(english);

        Discipline art = new Discipline("Art", false);
        art.addNewStudentForDiscipline(st5, generateMark());
        art.addNewStudentForDiscipline(st4, generateMark());
        art.addNewStudentForDiscipline(st7, generateMark());
        art.addNewStudentForDiscipline(st2, generateMark());
        System.out.println(art);


        System.out.println(st5 + " the biggest mark = " + strFormatFloat(findStudentInDiscipline(st5, math, english, art)));

    }

    /** Find student in all choose disciplines, and if find the student return the biggest Mark otherwise return 0.0f*/
    public static float findStudentInDiscipline(Student student, Discipline... disciplines){
        float maxMark = 0.0f;
        for(Discipline discipline : disciplines){
            if(discipline.listStudents.containsKey(student)){
                if(maxMark < discipline.listStudents.get(student))
                    maxMark = discipline.listStudents.get(student);
            }
        }
        return maxMark;
    }

    /** Return string from float with format %.2f */
    public static String strFormatFloat(float num){
        return String.format("%.2f", num);
    }


}
