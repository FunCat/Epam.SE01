package com.epam.javase.units.unit4.t02;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchReaderTest {

    @Test
    public void findWordInLineTest(){
        WordSearchReader wordSearchReader = new WordSearchReader();
        String line = "public class WordSearchReaderTest";
        wordSearchReader.findWordInLine(WordSearchReader.ListWords.PUBLIC, line);
        wordSearchReader.findWordInLine(WordSearchReader.ListWords.CLASS, line);
        int count = wordSearchReader.getCountMap().get(WordSearchReader.ListWords.PUBLIC);
        assertEquals(1, count);
        count = wordSearchReader.getCountMap().get(WordSearchReader.ListWords.CLASS);
        assertEquals(1, count);
        assertEquals(2, wordSearchReader.getCountMap().size());
    }

    @Test
    public void findWordWithSignsInLineTest(){
        WordSearchReader wordSearchReader = new WordSearchReader();
        String line = "try (BufferedReader buf = new BufferedReader(new FileReader(file)))";
        wordSearchReader.findWordInLine(WordSearchReader.ListWords.TRY, line);
        wordSearchReader.findWordInLine(WordSearchReader.ListWords.NEW, line);
        int count = wordSearchReader.getCountMap().get(WordSearchReader.ListWords.TRY);
        assertEquals(1, count);
        count = wordSearchReader.getCountMap().get(WordSearchReader.ListWords.NEW);
        assertEquals(2, count);
        assertEquals(2, wordSearchReader.getCountMap().size());
    }

    @Test
    public void findWordInLineTestWithNullArgs(){
        WordSearchReader wordSearchReader = new WordSearchReader();
        String line = "int count = 5;";
        wordSearchReader.findWordInLine(null, null);
        assertEquals(0, wordSearchReader.getCountMap().size());
        wordSearchReader.findWordInLine(null, line);
        assertEquals(0, wordSearchReader.getCountMap().size());
        wordSearchReader.findWordInLine(WordSearchReader.ListWords.INT, null);
        assertEquals(0, wordSearchReader.getCountMap().size());
    }

}