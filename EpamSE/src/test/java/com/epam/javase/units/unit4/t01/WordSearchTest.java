package com.epam.javase.units.unit4.t01;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordSearchTest {

    @Test
    public void findWordInLineTest(){
        WordSearch wordSearch = new WordSearch();
        String line = "public class WordSearchTest";
        wordSearch.findWordInLine(WordSearch.ListWords.PUBLIC, line);
        wordSearch.findWordInLine(WordSearch.ListWords.CLASS, line);
        int count = wordSearch.getCountMap().get(WordSearch.ListWords.PUBLIC);
        assertEquals(1, count);
        count = wordSearch.getCountMap().get(WordSearch.ListWords.CLASS);
        assertEquals(1, count);
        assertEquals(2, wordSearch.getCountMap().size());
    }

    @Test
    public void findWordWithSignsInLineTest(){
        WordSearch wordSearch = new WordSearch();
        String line = "try (BufferedReader buf = new BufferedReader(new FileReader(file)))";
        wordSearch.findWordInLine(WordSearch.ListWords.TRY, line);
        wordSearch.findWordInLine(WordSearch.ListWords.NEW, line);
        int count = wordSearch.getCountMap().get(WordSearch.ListWords.TRY);
        assertEquals(1, count);
        count = wordSearch.getCountMap().get(WordSearch.ListWords.NEW);
        assertEquals(2, count);
        assertEquals(2, wordSearch.getCountMap().size());
        wordSearch.findWordInLine(null, null);
    }

    @Test
    public void findWordInLineTestWithNullArgs(){
        WordSearch wordSearch = new WordSearch();
        String line = "int count = 5;";
        wordSearch.findWordInLine(null, null);
        assertEquals(0, wordSearch.getCountMap().size());
        wordSearch.findWordInLine(null, line);
        assertEquals(0, wordSearch.getCountMap().size());
        wordSearch.findWordInLine(WordSearch.ListWords.INT, null);
        assertEquals(0, wordSearch.getCountMap().size());
    }
}