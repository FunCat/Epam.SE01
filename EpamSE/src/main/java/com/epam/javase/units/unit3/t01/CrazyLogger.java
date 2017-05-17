package com.epam.javase.units.unit3.t01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrazyLogger {
    private StringBuilder stb = new StringBuilder();
    DateFormat df = new SimpleDateFormat("dd-MM-YYYY : hh-mm");

    public StringBuilder getStb() {
        return stb;
    }

    /** Add a new log in the StringBuilder with current date and time */
    public void addNewLog(String st){
        Calendar date = new GregorianCalendar();
        df.setTimeZone(date.getTimeZone());
        stb.append(df.format(date.getTime()) + " " +  st + "\n");
    }

    /** Write all logs in the console */
    public void writeAllLogs(){
        System.out.println(stb);
    }

    /** Find logs by the date */
    public void findLogsByDate(Calendar date){
        df.setTimeZone(date.getTimeZone());
        String d = df.format(date.getTime());
        Pattern patt = Pattern.compile(d +".*");
        StringBuilder res = findPattern(patt);

        System.out.println("Logs by date " + d + ":");
        System.out.println(res);
    }

    /** Find logs by the particular string in logs */
    public void findLogsByParticularString(String str){
        Pattern patt = Pattern.compile("\\d{2}-\\d{2}-\\d{4} : \\d{2}-\\d{2} " + str);
        StringBuilder res = findPattern(patt);

        System.out.println("Logs by string " + str + ":");
        System.out.println(res);
    }

    /** Find logs by the relative string in logs */
    public void findLogsByRelativeString(String str){
        Pattern patt = Pattern.compile("\\d{2}-\\d{2}-\\d{4} : \\d{2}-\\d{2} .*" + str + ".*");
        StringBuilder res = findPattern(patt);

        System.out.println("Logs by string " + str + ":");
        System.out.println(res);
    }

    /** Find logs by the pattern regex */
    private StringBuilder findPattern(Pattern patt){
        Matcher m = patt.matcher(stb);
        StringBuilder buf = new StringBuilder();
        boolean isFind = false;
        while (m.find()) {
            String text = m.group(0);
            buf.append("\t" + text + "\n");
            isFind = true;
        }
        if(!isFind)
            buf.append("\tNo matches!\n");
        return buf;
    }

    public static void main(String[] args) {
        CrazyLogger cl = new CrazyLogger();
        cl.addNewLog("New log #1");
        cl.addNewLog("New log #2");
        cl.writeAllLogs();
        cl.findLogsByDate(new GregorianCalendar(2017,4,17,8,5));
        cl.findLogsByDate(new GregorianCalendar());
        cl.findLogsByParticularString("New log #1");
        cl.findLogsByRelativeString("2");
    }
}
