package com.epam.javase.units.unit3.t03;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RegexTestTest {

    RegexTest regTest;

    @Before
    public  void initialize(){
        regTest = new RegexTest();
    }


    @Test
    public void testTrueOrder(){
        String line = "(Рис.1) (рис. 2) на рисунке 3 (Рис. 4)";
        regTest.isOrderNumbers(line);
        assertEquals(true, regTest.isOrder);
    }

    @Test
    public void testFalseOrder(){
        String line = "(Рис.1) (рис. 7) на рисунке 5 (Рис. 4)";
        regTest.isOrderNumbers(line);
        assertEquals(false, regTest.isOrder);
    }

    @Test
    public void testTrueOrderNotSerialNumbers(){
        String line = "(Рис.1) (рис. 3) на рисунке 7 (Рис. 10)";
        regTest.isOrderNumbers(line);
        assertEquals(true, regTest.isOrder);
    }

    @Test
    public void testTrueOrderWithText(){
        String line = "На рисунке 1 показаны короткодействующие силы в неполных магнетонах нейтронов и протонов (рис. 2), совместно образовавшие силовые структуры притяжения (Рис.3) в двух полных ядерных магнетонах – полных ядерных нанотрубках альфы (рис.5) и четыре совместные силовые структуры притяжения в неполных нанотрубках.(Рис. 10)\n";
        regTest.isOrderNumbers(line);
        assertEquals(true, regTest.isOrder);
    }


}