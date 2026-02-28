package algo.java.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {
    ValidParentheses sut = new ValidParentheses();

    @Test
    public void isValid_tests() {
        // Positive tests
        assertTrue(sut.isValid(null));
        assertTrue(sut.isValid(""));
        assertTrue(sut.isValid("test"));
        assertTrue(sut.isValid("{}"));
        assertTrue(sut.isValid("()"));
        assertTrue(sut.isValid("()[]{}"));
        assertTrue(sut.isValid("(())[{}]{()}"));
        assertTrue(sut.isValid("{as[(sd(testing))test]bla}"));

        // Negative tests
        assertFalse(sut.isValid("["));
        assertFalse(sut.isValid("testing[done]{invalid"));
    }
}
