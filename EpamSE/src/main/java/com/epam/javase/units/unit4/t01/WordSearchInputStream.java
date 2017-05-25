package com.epam.javase.units.unit4.t01;

import java.io.*;
import java.util.EnumMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearchInputStream {

    enum ListWords {
        ABSTRACT("abstract"), CONTINUE("continue"), FOR("for"), NEW("new"), SWITCH("switch"),
        ASSERT("assert"), DEFAULT("default"), GOTO("goto"), PACKAGE("package"), SYNCHRONIZED("synchronized"),
        BOOLEAN("boolean"), DO("do"), IF("if"), PRIVATE("private"), THIS("this"),
        BREAK("break"), DOUBLE("double"), IMPLEMENTS("implements"), PROTECTED("protected"), THROW("throw"),
        BYTE("byte"), ELSE("else"), IMPORT("import"), PUBLIC("public"), THROWS("throws"),
        CASE("case"), ENUM("enum"), INSTANCEOF("instanceof"), RETURN("return"), TRANSIENT("transient"),
        CATCH("catch"), EXTENDS("extends"), INT("int"), SHORT("short"), TRY("try"),
        CHAR("char"), FINAL("final"), INTERFACE("interface"), STATIC("static"), VOID("void"),
        CLASS("class"), FINALLY("finally"), LONG("long"), STRICTFP("strictfp"), VOLATILE("volatile"),
        CONST("const"), FLOAT("float"), NATIVE("native"), SUPER("super"), WHILE("while");

        private final String text;

        ListWords(final String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }

    private EnumMap<ListWords, Integer> countMap = new EnumMap<>(ListWords.class);

    public EnumMap<ListWords, Integer> getCountMap() {
        return countMap;
    }

    public static void main(String[] args) {
        WordSearchInputStream wordSearchInputStream = new WordSearchInputStream();
        for(ListWords word: ListWords.values()) {
            try(DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(WordSearchInputStream.class.getResource("javatext.txt").getFile())))) {
                wordSearchInputStream.findWordInFile(word, dis);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(wordSearchInputStream.countMap);
    }

    /** Find word in a file and counts the number of coincidences*/
    public void findWordInFile(ListWords word, DataInputStream dis){
        try {
            while (dis.available() > 0){
                String line = dis.readLine();
                findWordInLine(word, line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Find word in a string and counts the number of coincidences*/
    public void findWordInLine(ListWords word, String line){
        if(word == null) { System.out.println("You didn't specify a search word!"); return;}
        if(line == null){ System.out.println("You didn't specify a string!"); return;}
        Pattern pat = Pattern.compile("[()=;_.]*(" + word.text + ")\\s+");
        Matcher matcher = pat.matcher(line);
        while(matcher.find()){
            if(countMap.containsKey(word)) {
                Integer count = countMap.get(word);
                countMap.put(word, ++count);
            }
            else
            {
                countMap.put(word, 1);
            }
        }
    }
}
