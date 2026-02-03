package algo.java.data.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTests {
    LinkedList<String> sut;

    @BeforeEach
    public void initialzie() {
        sut = new LinkedList<>();
    }

    @Test 
    public void linkedList_tests() {
        assertNull(sut.getFirst());
        assertNull(sut.getLast());

        sut.addLast("test");
        sut.addLast("test2");
        sut.addLast("test3");

        sut.print();

        assertEquals("test", sut.getFirst());
        assertEquals("test3", sut.getLast());
        
        assertEquals("test", sut.removeFirst());
        assertEquals("test2", sut.getFirst());
        assertEquals("test3", sut.getLast());
        sut.print();

        
        sut.addLast("test4");
        sut.print();
        assertEquals("test4", sut.removeLast());
        sut.print();
        assertEquals("test3", sut.getLast());
    }

}
