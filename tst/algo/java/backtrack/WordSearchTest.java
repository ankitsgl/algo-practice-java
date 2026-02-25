package algo.java.backtrack;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class WordSearchTest {
    private final char[][] board = {
            {'a','b','c','d'},
            {'a','x','z','d'},
            {'a','a','c','d'},
            {'a','b','c','d'},
    };

    private final WordSearch sut = new WordSearch();

    @Test void wordExists_true() {
        assertTrue(sut.exists(board, "abczxa"));
    }  
    
    @Test void wordExists_false() {
        assertFalse(sut.exists(board, "abcfxa"));
    }
    
    @Test void searchSingleWord_success() {
        List<String> words = List.of("abczxa");

        List<String> foundWords = sut.searchWords(board, words);

        assertEquals(1, foundWords.size());
        assertEquals(words.get(0), foundWords.get(0));
    } 
    
    @Test void searchMultipleWord_success() {
        List<String> words = List.of("abczxa", "dcba");

        List<String> foundWords = sut.searchWords(board, words);

        assertEquals(2, foundWords.size());
        assertTrue(foundWords.contains(words.get(0)));
        assertTrue(foundWords.contains(words.get(1)));
    }

    @Test void searchMultipleWord_notFound() {
        List<String> words = List.of("abdzxa", "dssa");

        List<String> foundWords = sut.searchWords(board, words);

        assertEquals(0, foundWords.size());
    }
}
