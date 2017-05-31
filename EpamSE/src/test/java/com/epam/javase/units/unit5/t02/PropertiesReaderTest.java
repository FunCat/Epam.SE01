package com.epam.javase.units.unit5.t02;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PropertiesReaderTest {

    PropertiesReader pr;

    @Before
    public void initialization(){
        pr = new PropertiesReader("config.properties");
    }

    @Test
    public void getProperty() throws Exception {
        boolean actualBoolean = pr.getBoolean("varBoolean");
        assertEquals(true, actualBoolean);

        byte actualByte = pr.getByte("varByte");
        assertEquals(15, actualByte);

        short actualShort = pr.getShort("varShort");
        assertEquals(500, actualShort);

        int actualInt = pr.getInt("varInt");
        assertEquals(5, actualInt);

        long actualLong = pr.getLong("varLong");
        assertEquals(100000000000000l, actualLong);

        float actualFloat = pr.getFloat("varFloat");
        assertEquals(1.4f, actualFloat, 0.1);

        double actualDouble = pr.getDouble("varDouble");
        assertEquals(2.58, actualDouble, 0.1);

        char actualChar = pr.getChar("varChar");
        assertEquals('r', actualChar);

        String actualString = pr.getString("varString");
        assertEquals("Hello World!", actualString);
    }

    @Test(expected = ClassCastException.class)
    public void getPropertyClassCastExceptionBoolean() throws Exception {
        boolean actualBoolean = pr.getBoolean("varChar");
    }

    @Test(expected = NumberFormatException.class)
    public void getPropertyNumberFormatExceptionByte() throws Exception {
        byte actualByte = pr.getByte("varChar");
    }

    @Test(expected = NumberFormatException.class)
    public void getPropertyNumberFormatExceptionShort() throws Exception {
        short actualShort = pr.getShort("varChar");
    }

    @Test(expected = NumberFormatException.class)
    public void getPropertyNumberFormatExceptionInt() throws Exception {
        int actualInt = pr.getInt("varChar");
    }

    @Test(expected = NumberFormatException.class)
    public void getPropertyNumberFormatExceptionLong() throws Exception {
        long actualLong = pr.getLong("varChar");
    }

    @Test(expected = NumberFormatException.class)
    public void getPropertyNumberFormatExceptionFloat() throws Exception {
        float actualFloat = pr.getFloat("varChar");
    }

    @Test(expected = NumberFormatException.class)
    public void getPropertyNumberFormatExceptionDouble() throws Exception {
        double actualDouble = pr.getDouble("varChar");
    }
}