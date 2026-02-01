package algo.java.data.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueTests {
    Queue<String> sut;

    @BeforeEach
    public void initialzie() {
        sut = new Queue<>();
    }

    @Test 
    public void enqueue_dequeue_test() {
        String data = "test";

        sut.enqueue(data);

        assertEquals(1, sut.size());
        assertEquals("test", sut.dequeue());
        assertEquals(0, sut.size());
    }

    @Test 
    public void peek_test() {
        String data = "test";

        sut.enqueue(data);

        assertEquals(1, sut.size());
        assertEquals("test", sut.peek());
        assertEquals(1, sut.size());
    }
}
