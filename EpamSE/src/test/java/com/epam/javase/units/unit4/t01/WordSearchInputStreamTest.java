package com.epam.javase.units.unit4.t01;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchInputStreamTest {

    @Test
    public void findWordInLineTest(){
        WordSearchInputStream wordSearchInputStream = new WordSearchInputStream();
        String line = "public class WordSearchInputStreamTest";
        wordSearchInputStream.findWordInLine(WordSearchInputStream.ListWords.PUBLIC, line);
        wordSearchInputStream.findWordInLine(WordSearchInputStream.ListWords.CLASS, line);
        int count = wordSearchInputStream.getCountMap().get(WordSearchInputStream.ListWords.PUBLIC);
        assertEquals(1, count);
        count = wordSearchInputStream.getCountMap().get(WordSearchInputStream.ListWords.CLASS);
        assertEquals(1, count);
        assertEquals(2, wordSearchInputStream.getCountMap().size());
    }

    @Test
    public void findWordWithSignsInLineTest(){
        WordSearchInputStream wordSearchInputStream = new WordSearchInputStream();
        String line = "try (BufferedReader buf = new BufferedReader(new FileReader(file)))";
        wordSearchInputStream.findWordInLine(WordSearchInputStream.ListWords.TRY, line);
        wordSearchInputStream.findWordInLine(WordSearchInputStream.ListWords.NEW, line);
        int count = wordSearchInputStream.getCountMap().get(WordSearchInputStream.ListWords.TRY);
        assertEquals(1, count);
        count = wordSearchInputStream.getCountMap().get(WordSearchInputStream.ListWords.NEW);
        assertEquals(2, count);
        assertEquals(2, wordSearchInputStream.getCountMap().size());
    }

    @Test
    public void findWordInLineTestWithNullArgs(){
        WordSearchInputStream wordSearchInputStream = new WordSearchInputStream();
        String line = "int count = 5;";
        wordSearchInputStream.findWordInLine(null, null);
        assertEquals(0, wordSearchInputStream.getCountMap().size());
        wordSearchInputStream.findWordInLine(null, line);
        assertEquals(0, wordSearchInputStream.getCountMap().size());
        wordSearchInputStream.findWordInLine(WordSearchInputStream.ListWords.INT, null);
        assertEquals(0, wordSearchInputStream.getCountMap().size());
    }
}