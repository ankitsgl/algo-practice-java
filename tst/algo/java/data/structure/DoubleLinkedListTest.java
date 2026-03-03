package algo.java.data.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoubleLinkedListTest {
    @Test
    public void crud_tests() {
        DoubleLinkedList<Integer> dll = new DoubleLinkedList<>();
        dll.addFirst(1);
        assertEquals("[1<->]", dll.toString());
        dll.clear();

        dll.addLast(2);
        assertEquals("[2<->]", dll.toString());
        dll.clear();

        dll.addFirst(1);
        dll.addLast(2);
        assertEquals("[1<->2<->]", dll.toString());
        dll.addFirst(0);
        assertEquals("[0<->1<->2<->]", dll.toString());
        assertEquals(0, dll.removeFirst());
        assertEquals("[1<->2<->]", dll.toString());
        assertEquals(2, dll.removeLast());
        assertEquals("[1<->]", dll.toString());
        dll.clear();

        dll.addAll(1,2,3,4);
        assertEquals("[1<->2<->3<->4<->]", dll.toString());
        dll.remove(2);
        assertEquals("[1<->3<->4<->]", dll.toString());
        dll.remove(1);
        assertEquals("[3<->4<->]", dll.toString());
        dll.remove(4);
        assertEquals("[3<->]", dll.toString());
        dll.remove(3);
        assertEquals("[]", dll.toString());
    }
}
