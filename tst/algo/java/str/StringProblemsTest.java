package algo.java.str;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringProblemsTest {
    private final StringProblems sut = new StringProblems();
    @Test
    public void reverse_test() {
        assertEquals("", sut.reverse(""));
        assertEquals("a", sut.reverse("a"));
        assertEquals("ak", sut.reverse("ka"));
        assertEquals("ankit", sut.reverse("tikna"));
    }
}
