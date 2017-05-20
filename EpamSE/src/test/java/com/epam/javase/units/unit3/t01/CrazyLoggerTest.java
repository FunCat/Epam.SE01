package com.epam.javase.units.unit3.t01;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class CrazyLoggerTest {



    @Test
    public void addNewLog() throws Exception {
        CrazyLogger cl = new CrazyLogger();
        cl.addNewLog("New log #1");
        cl.addNewLog("New log #2");

        Calendar date = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
        df.setTimeZone(date.getTimeZone());
        String expected = df.format(date.getTime()) + " New log #1\n" + df.format(date.getTime()) + " New log #2\n";
        assertEquals(expected, cl.getStb().toString());

        cl.addNewLog("");
        assertEquals(expected, cl.getStb().toString());
    }

    @Test
    public void findLogsByDate() throws Exception {
        CrazyLogger cl = new CrazyLogger();
        cl.getStb().append("19-05-2017 : 08-00 Another date\r\n");
        cl.addNewLog("New log #1");

        Calendar date = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
        df.setTimeZone(date.getTimeZone());

        String actual = cl.findLogsByDate(new GregorianCalendar(2017,4,19,8,0));
        String expected = "Logs by date 19-05-2017 : 08-00:\n\t19-05-2017 : 08-00 Another date\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByDate(new GregorianCalendar());
        expected = "Logs by date " + df.format(date.getTime()) + ":\n\t" + df.format(date.getTime()) + " New log #1\n";
        assertEquals(expected, actual);
    }

    @Test
    public void findLogsByParticularString() throws Exception {
        CrazyLogger cl = new CrazyLogger();
        cl.getStb().append("19-05-2017 : 08-00 Another date\n");
        cl.addNewLog("New log #1");

        Calendar date = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
        df.setTimeZone(date.getTimeZone());


        String actual = cl.findLogsByParticularString("Another date");
        String expected = "Logs by string Another date:\n\t19-05-2017 : 08-00 Another date\n\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByParticularString("New lg");
        expected = "Logs by string New lg:\n\tNo matches!\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByParticularString("New log #1");
        expected = "Logs by string New log #1:\n\t" + df.format(date.getTime()) + " New log #1\n\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByParticularString("");
        expected = "Logs by string :\n\tNo matches!\n";
        assertEquals(expected, actual);
    }

    @Test
    public void findLogsByRelativeString() throws Exception {
        CrazyLogger cl = new CrazyLogger();
        cl.getStb().append("19-05-2017 : 08-00 Another date\r\n");
        cl.addNewLog("New log #1");

        Calendar date = new GregorianCalendar();
        DateFormat df = new SimpleDateFormat("dd-MM-YYYY : hh-mm");
        df.setTimeZone(date.getTimeZone());

        String actual = cl.findLogsByRelativeString("date");
        String expected = "Logs by string date:\n\t19-05-2017 : 08-00 Another date\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByRelativeString("log");
        expected = "Logs by string log:\n\t" + df.format(date.getTime()) + " New log #1\n";
        assertEquals(expected, actual);

        cl.addNewLog("New log #2");
        actual = cl.findLogsByRelativeString("log");
        expected = "Logs by string log:\n\t" + df.format(date.getTime()) + " New log #1\n\t" + df.format(date.getTime()) + " New log #2\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByRelativeString("");
        expected = "Logs by string :\n\t19-05-2017 : 08-00 Another date\n\t" + df.format(date.getTime()) + " New log #1\n\t" + df.format(date.getTime()) + " New log #2\n";
        assertEquals(expected, actual);

        cl.addNewLog("New\nlog #3");
        actual = cl.findLogsByRelativeString("log");
        expected = "Logs by string log:\n\t" + df.format(date.getTime()) + " New log #1\n\t" + df.format(date.getTime()) + " New log #2\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByRelativeString("New");
        expected = "Logs by string New:\n\t" + df.format(date.getTime()) + " New log #1\n\t" + df.format(date.getTime()) + " New log #2\n\t" + df.format(date.getTime()) + " New\n";
        assertEquals(expected, actual);

        actual = cl.findLogsByRelativeString("New\nlog");
        expected = "Logs by string New\nlog:\n\t" + df.format(date.getTime()) + " New\nlog #3\n";
        assertEquals(expected, actual);
    }
}