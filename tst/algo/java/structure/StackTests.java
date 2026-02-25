package algo.java.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTests {
    Stack<String> sut;

    @BeforeEach
    public void initialzie() {
        sut = new Stack<>();
    }

    @Test 
    public void push_pop_test() {
        sut.push("test");
        sut.push("test2");

        assertEquals(2, sut.size());
        assertEquals("test2", sut.pop());
        assertEquals(1, sut.size());
    }

    @Test 
    public void peek_test() {
        sut.push("test");
        sut.push("test2");

        assertEquals(2, sut.size());
        assertEquals("test2", sut.peek());
        assertEquals(2, sut.size());
    }
}
