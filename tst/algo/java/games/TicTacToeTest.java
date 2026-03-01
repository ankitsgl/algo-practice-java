package algo.java.games;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {
    private final TicTacToe game = new TicTacToe(3);
    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = 2;

    @Test public void move_success() {
        assertEquals(0, game.move(PLAYER_1, 0, 0));
        assertEquals(0, game.move(PLAYER_2, 1, 0));
        assertEquals(0, game.move(PLAYER_1, 0, 1));
        assertEquals(0, game.move(PLAYER_2, 2, 0));
        assertEquals(1, game.move(PLAYER_1, 0, 2));
    }

    @Test public void move_invalidLocation_throws() {
        assertThrows(RuntimeException.class, () -> game.move(PLAYER_1, -1, 0));
        assertThrows(RuntimeException.class, () -> game.move(PLAYER_1, 0, -1));
        assertThrows(RuntimeException.class, () -> game.move(PLAYER_1, 0, 4));
        assertThrows(RuntimeException.class, () -> game.move(PLAYER_1, 4, 0));
    }

    @Test public void move_repeatedMove_throws() {
        assertEquals(0, game.move(PLAYER_1, 0, 0));
        assertThrows(RuntimeException.class, () -> game.move(PLAYER_2, 0, 0));
    }

    @Test public void move_samePlayer_throws() {
        assertEquals(0, game.move(PLAYER_1, 0, 0));
        assertThrows(RuntimeException.class, () -> game.move(PLAYER_1, 0, 1));
    }
}
