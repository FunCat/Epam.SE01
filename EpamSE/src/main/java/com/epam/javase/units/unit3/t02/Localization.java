package com.epam.javase.units.unit3.t02;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Scanner;

public class Localization {
    static int countQuestions = 5;
    static ResourceBundle tb;

    public static void main(String[] args) {
        selectLanguage();
        System.out.println(tb.getString("questions"));
        for(int i = 1; i <= countQuestions; i++){
            String val = tb.getString("question"+i);
            System.out.println(i + " - " + val);
        }
        System.out.println(countQuestions + 1 + " - Exit");
        while(findAnswer());
    }

    /** User select language and program include the necessary locale */
    public static void selectLanguage(){
        System.out.println("Select language:");
        System.out.println("1 - English");
        System.out.println("2 - Русский");
        System.out.print("Enter the number of chosen language: ");
        Scanner in = new Scanner(System.in);
        int lang = in.nextInt();
        switch(lang){
            case 1:
                tb = ResourceBundle.getBundle("com/epam/javase/units/unit3/t02/Locale", new Locale("en", "US"));
                break;
            case 2:
                tb = ResourceBundle.getBundle("com/epam/javase/units/unit3/t02/Locale", new Locale("ru", "RU"));
                break;
            default:
                tb = ResourceBundle.getBundle("com/epam/javase/units/unit3/t02/Locale", new Locale("en", "US"));
        }
    }

    /** Finds the answer by the index of question, return true - if the method found the answer otherwise return false*/
    public static boolean findAnswer(){
        System.out.print(tb.getString("choose_question"));
        Scanner in = new Scanner(System.in);
        int index = in.nextInt();
        if(index > 0 && index <= countQuestions) {
            String val = tb.getString("answer"+index);
            System.out.println(tb.getString("answer") + index + ": " + val);
        }
        else{
            if(index == countQuestions + 1) return false;
            System.out.println(tb.getString("wrong_index"));
        }
        return true;
    }
}
