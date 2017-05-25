package com.epam.javase.units.unit3.t03;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    static int checkOrderNumber = 0;
    static boolean isOrder = true;

    public static void main(String[] args) throws FileNotFoundException{
            File file = new File(RegexTest.class.getResource("test.html").getFile());
            try (BufferedReader buf = new BufferedReader(new FileReader(file))) {
                while(buf.ready()) {
                    String line = buf.readLine();
                    isOrderNumbers(line);
                    writeTextWithLinks(line);
                }
                System.out.println("===============================================");
                System.out.println("The order: " + isOrder);
            }
            catch (IOException ex){

            }
    }

    /** Writes all the text which has the link to the picture */
    public static void writeTextWithLinks(String line) {
        Pattern patt2 = Pattern.compile("^<(div|p)>(.*((\\([рР]ис\\.*\\s*(\\d+)\\))|([Нн]а\\s*рисунке\\s*(\\d+))).*)<\\/(div|p)>");
        Matcher m2 = patt2.matcher(line);
        while(m2.find()){
            System.out.println(m2.group(2));
            System.out.println();
        }
    }

    /** Check that the line has serial links */
    public static void isOrderNumbers(String line) {
        Pattern patt1 = Pattern.compile("(\\([рР]ис\\.*\\s*(\\d+)\\))|([Нн]а\\s*рисунке\\s*(\\d+))");
        Matcher m1 = patt1.matcher(line);
        while (m1.find()) {
            int nowNumber = 0;
            if(m1.group(2) != null) nowNumber = Integer.parseInt(m1.group(2));
            if(m1.group(4) != null) nowNumber = Integer.parseInt(m1.group(4));
            if(isOrder){
                if(checkOrderNumber > nowNumber) isOrder = false;
                else checkOrderNumber = nowNumber;
            }
        }
    }
}
