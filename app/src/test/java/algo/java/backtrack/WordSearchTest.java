package algo.java.backtrack;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import algo.java.utils.ArrayUtils;

public class WordSearchTest {
    WordSearch sut = new WordSearch();

    @Test void wordExists_true() {
        char[][] board = {
            {'a','b','c','d'},
            {'a','x','z','d'},
            {'a','a','c','d'},
            {'a','b','c','d'},
        };

        ArrayUtils.printArray(board);

        assertTrue(sut.exists(board, "abczxa"));
    }  
    
    @Test void wordExists_false() {
        char[][] board = {
            {'a','b','c','d'},
            {'a','x','z','d'},
            {'a','a','c','d'},
            {'a','b','c','d'},
        };

        ArrayUtils.printArray(board);

        assertFalse(sut.exists(board, "abcfxa"));
    }   
    
    
    @Test void searchSingleWord_success() {
        char[][] board = {
            {'a','b','c','d'},
            {'a','x','z','d'},
            {'a','a','c','d'},
            {'a','b','c','d'},
        };

        List<String> words = List.of("abczxa");
        ArrayUtils.printArray(board);

        List<String> foundWords = sut.searchWords(board, words);

        assertEquals(1, foundWords.size());
        assertEquals(words.get(0), foundWords.get(0));
    } 
    
    @Test void searchMultipleWord_success() {
        char[][] board = {
            {'a','b','c','d'},
            {'a','x','z','d'},
            {'a','a','c','d'},
            {'a','b','c','d'},
        };

        List<String> words = List.of("abczxa", "dcba");
        ArrayUtils.printArray(board);

        List<String> foundWords = sut.searchWords(board, words);

        assertEquals(2, foundWords.size());
        assertTrue(foundWords.contains(words.get(0)));
        assertTrue(foundWords.contains(words.get(1)));
    } 
}
