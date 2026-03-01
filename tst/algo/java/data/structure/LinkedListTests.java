package algo.java.data.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LinkedListTests {
    LinkedList<String> sut;

    @BeforeEach
    public void initialzie() {
        sut = new LinkedList<String>();
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

    @Test
    public void fromArray_test() {
        Integer[] array = {1,2,3,4};

        LinkedList<Integer> linkedList = LinkedList.fromArray(array);

        assertEquals(1, linkedList.getFirst());
        assertEquals(4, linkedList.getLast());
    }

    @Test
    public void reverse_test() {
        Integer[] array = {1,2,3,4};

        LinkedList<Integer> linkedList = LinkedList.fromArray(array);
        linkedList.print();
        linkedList.reverse();
        linkedList.print();

        assertEquals("[4->3->2->1->]", linkedList.toString());
    }

    @Test
    public void partialReverse_test_inBetween() {
        Integer[] array = {1,2,3,4,5,6};

        LinkedList<Integer> linkedList = LinkedList.fromArray(array);
        linkedList.print();
        linkedList.partialReverse(3,5);
        linkedList.print();

        assertEquals("[1->2->5->4->3->6->]", linkedList.toString());
    }

    @Test
    public void partialReverse_test_full() {
        Integer[] array = {1,2,3,4,5,6};

        LinkedList<Integer> linkedList = LinkedList.fromArray(array);
        linkedList.print();
        linkedList.partialReverse(1,6);
        linkedList.print();

        assertEquals("[6->5->4->3->2->1->]", linkedList.toString());
    }

    @Test
    public void partialReverse_test_firstPart() {
        Integer[] array = {1,2,3,4,5,6};

        LinkedList<Integer> linkedList = LinkedList.fromArray(array);
        linkedList.print();
        linkedList.partialReverse(1,4);
        linkedList.print();

        assertEquals("[4->3->2->1->5->6->]", linkedList.toString());
    }

    @Test
    public void partialReverse_test_secondPart() {
        Integer[] array = {1,2,3,4,5,6};

        LinkedList<Integer> linkedList = LinkedList.fromArray(array);
        linkedList.print();
        linkedList.partialReverse(3,6);
        linkedList.print();

        assertEquals("[1->2->6->5->4->3->]", linkedList.toString());
    }
}
