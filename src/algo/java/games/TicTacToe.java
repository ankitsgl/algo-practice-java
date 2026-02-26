package algo.java.games;

import java.util.Scanner;

/*
Leetcode: https://leetcode.com/problems/design-tic-tac-toe/description/
Youtube: https://www.youtube.com/watch?v=gktZsX9Z8Kw&t=4s
 */
public class TicTacToe {
    private final int boardSize;
    private int[][] board;

    private int[] rowSum;
    private int[] colSum;
    private int diagnalSum;
    private int revDiagnalSum;
    private int lastPlayer;

    public TicTacToe(int boardSize) {
        this.boardSize = boardSize;

        // Initialize board
        board = new int[boardSize][];
        for(int index = 0; index < boardSize; index++) {
            board[index] = new int[boardSize];
        }

        rowSum = new int[boardSize];
        colSum = new int[boardSize];
    }

    public int move(final int playerNumber, final int row, final int col) {
        if (playerNumber < 1 || playerNumber >  2) {
            throw new RuntimeException("Invalid player");
        }

        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            throw new RuntimeException("Invalid location");
        }

        if (board[row][col] != 0) {
            throw new RuntimeException("Move not allowed");
        }

        if (playerNumber == lastPlayer) {
            throw new RuntimeException("Same player can't move again");
        }

        lastPlayer = playerNumber;

        int player = playerNumber == 1 ? -1 : +1;

        // Make a move
        board[row][col] = player;
        rowSum[row] = rowSum[row] + player;
        colSum[col] = colSum[col] + player;
        if ( row == col) {
            diagnalSum = diagnalSum + player;
        }

        if (row == boardSize - 1 - col) {
            revDiagnalSum = revDiagnalSum + player;
        }

        if (Math.abs(rowSum[row]) == boardSize ||
                Math.abs(colSum[col]) == boardSize ||
                Math.abs(diagnalSum) == boardSize ||
                Math.abs(revDiagnalSum) == boardSize) {
            return playerNumber;
        }

        return 0;
    }

    public int[][] getBoard() {
        return board;
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            System.out.print("%s: [".formatted(i));
            for (int j = 0; j < board[i].length; j++) {
                System.out.print((board[i][j] == 0 ? " ":
                        (board[i][j] == -1 ? "x": "o")) +
                        (j == board[i].length -1 ? "" : ","));
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Lets play TicTacToe game... Enter -1 to exit");
        TicTacToe game = new TicTacToe(3);
        game.printBoard();

        int player = 1;
        String input = "";
        Scanner scanner = new Scanner(System.in);

        while(input != "-1") {
            try {
                System.out.print("Player %s enter row,col: ".formatted(player));
                input = scanner.nextLine();
                int row = Integer.parseInt(input.split(",")[0]);
                int col = Integer.parseInt(input.split(",")[1]);
                if (game.move(player, row, col) != 0) {
                    game.printBoard();
                    System.out.println("Player %s won!".formatted(player));
                    break;
                }
                player = player == 1 ? 2 : 1;
                game.printBoard();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
