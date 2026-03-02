package algo.java.area;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaximalSquareTest {
    private final MaximalSquare sut = new MaximalSquare();

    @Test
    public void maximumSquare_test() {
        char[][] metrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        assertEquals(2, sut.maximalSquare(metrix));
    }

    @Test
    public void maximalSquareOptimized_test() {
        char[][] metrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        assertEquals(2, sut.maximalSquare(metrix));
    }
}
