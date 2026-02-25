package algo.java.backtrack;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    private final int[][] possibleMoves = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public Boolean exists(char[][] board, String word) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++) {
                if (dfs(board, r, c, word, 0))
                    return true;
            }
        }
        return false;
    }

    public List<String> searchWords(char[][] board, List<String> words) {
        List<String> foundWords = new ArrayList<>();

        for (String word : words) {
            for(int r = 0; r < board.length; r++){
               for(int c = 0; c < board[0].length; c++) {
                    if (dfs(board, r, c, word, 0))
                        foundWords.add(word);
                }
            }
        }
            
        return foundWords;
    }

    private Boolean dfs(char[][] board, int r, int c, String word, int index) {
        if (r < 0 || 
            r >= board.length||
            c < 0 || 
            c >= board[0].length ||
            board[r][c] == '#' || // Aleady visited
            board[r][c] != word.charAt(index)) {
            return false;
        }

        // full word is found in board. 
        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        for (int[] possibleMove : possibleMoves) {
            if (dfs(board, r + possibleMove[0], c + possibleMove[1], word, index + 1)) {
                return true;
            }
        }

        board[r][c] = temp;

        return false;
    }
}
