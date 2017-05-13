package com.epam.javase.units.unit2.t5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisciplineTest {

    Student st1;
    Student st2;
    Student st3;
    Discipline math;
    Discipline english;
    Discipline art;

    @Before
    public  void initialize() {
        st1 = new Student("Sergey", "Petrov", 1996);
        st2 = new Student("Maksim", "Andreev", 1994);
        st3 = new Student("Vitalii", "Bektimirov", 1995);

        math = new Discipline("Math", false);
        english = new Discipline("English", true);
        art = new Discipline("Art", false);
    }

    @Test
    public void addNewStudentForDiscipline() throws Exception {
        float mark1 = 4.2f;
        math.addNewStudentForDiscipline(st1, mark1);
        Assert.assertEquals(1, math.getListStudents().size());
        Assert.assertEquals(true, math.getListStudents().containsKey(st1));
        Assert.assertEquals(mark1, math.getListStudents().get(st1), 0.0001);

        math.addNewStudentForDiscipline(null, mark1);
        Assert.assertEquals(1, math.getListStudents().size());
        Assert.assertEquals(true, math.getListStudents().containsKey(st1));
        Assert.assertEquals(false, math.getListStudents().containsKey(null));
        Assert.assertEquals(mark1, math.getListStudents().get(st1), 0.0001);

        float mark2 = -0.5f;
        math.addNewStudentForDiscipline(st2, mark2);
        Assert.assertEquals(2, math.getListStudents().size());
        Assert.assertEquals(true, math.getListStudents().containsKey(st1));
        Assert.assertEquals(true, math.getListStudents().containsKey(st2));
        Assert.assertEquals(mark1, math.getListStudents().get(st1), 0.0001);
        Assert.assertEquals(2.0f, math.getListStudents().get(st2), 0.0001);

        float mark3 = 6.5f;
        math.addNewStudentForDiscipline(st3, mark3);
        Assert.assertEquals(3, math.getListStudents().size());
        Assert.assertEquals(true, math.getListStudents().containsKey(st1));
        Assert.assertEquals(true, math.getListStudents().containsKey(st2));
        Assert.assertEquals(true, math.getListStudents().containsKey(st3));
        Assert.assertEquals(mark1, math.getListStudents().get(st1), 0.0001);
        Assert.assertEquals(2.0f, math.getListStudents().get(st2), 0.0001);
        Assert.assertEquals(5.0f, math.getListStudents().get(st3), 0.0001);
    }

    @Test
    public void findStudentInDiscipline() throws Exception {
        float mark1 = 4.2f;
        float mark2 = 3.8f;
        float mark3 = 4.1f;
        math.addNewStudentForDiscipline(st1, mark1);
        english.addNewStudentForDiscipline(st1, mark2);
        art.addNewStudentForDiscipline(st1, mark3);

        float maxValue = Discipline.findStudentInDiscipline(st1, math, english, art);

        Assert.assertEquals(true, math.getListStudents().containsKey(st1));
        Assert.assertEquals(true, english.getListStudents().containsKey(st1));
        Assert.assertEquals(true, art.getListStudents().containsKey(st1));
        Assert.assertEquals(mark1, maxValue, 0.0001f);

        maxValue = Discipline.findStudentInDiscipline(st1, english, art);
        Assert.assertEquals(mark3, maxValue, 0.0001f);
    }

}