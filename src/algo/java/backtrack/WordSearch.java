package algo.java.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
Problem: https://leetcode.com/problems/word-search/description/
Submission: https://leetcode.com/problems/word-search/submissions/1931387907/
 */
public class WordSearch {
    private final int[][] MOVES = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public Boolean exists(char[][] board, String word) {
        final int rows = board.length;
        final int cols = board[0].length;

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (dfs(board, r, c, word, 0))
                        return true;
                }
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

    private Boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (row < 0 ||
                row >= board.length ||
                col < 0 ||
                col >= board[0].length ||
                board[row][col] == '#' || // Aleady visited
                board[row][col] != word.charAt(index)) {
            return false;
        }

        // full word is found in board.
        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        for (int[] move : MOVES) {
            if (dfs(board, row + move[0], col + move[1], word, index + 1)) {
                return true;
            }
        }

        board[row][col] = temp;

        return false;
    }
}
