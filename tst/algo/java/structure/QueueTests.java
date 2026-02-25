package algo.java.structure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTests {
    Queue<String> sut;

    @BeforeEach
    public void initialzie() {
        sut = new Queue<>();
    }

    @Test 
    public void enqueue_dequeue_test() {
        sut.enqueue("test");
        sut.enqueue("test2");

        assertEquals(2, sut.size());
        assertEquals("test", sut.dequeue());
        assertEquals(1, sut.size());
    }

    @Test 
    public void peek_test() {
        sut.enqueue("test");
        sut.enqueue("test2");

        assertEquals(2, sut.size());
        assertEquals("test", sut.peek());
        assertEquals(2, sut.size());
    }
}
