package algo.java.data.structure;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addLast(T data)
    {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        } 
            
        tail.next = node;
        tail = node;
    }

    public void addFirst(T data)
    {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        } 
            
        node.next = head;
        head = node;
    }

    public T removeFirst() {
        if (head == null) {
            return null;
        }

        Node<T> currentHead = head;
        head = head.next;
        return currentHead.data;
    }

    public T removeLast() {
        if (tail == null) {
            // Linkedlist is empty
            return null;
        }

        Node<T> current = head;
        while(current.next.next != null) {
            current = current.next;
        }

        Node<T> currentTail = current.next;
        current.next = null;
        tail = current;
        return currentTail.data;
    }

    public T getFirst() {
        if (head == null) {
            return null;
        }

        return head.data;
    }

    public T getLast() {
        if (tail == null) {
            return null;
        }

        return tail.data;
    }

    public void print() {
        Node<T> current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print("%s->".formatted(current.data));
            current = current.next;
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        Node<T> current = head;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (current != null) {
            sb.append("%s->".formatted(current.data));
            current = current.next;
        }
        sb.append("]");

        return sb.toString();
    }

    public static <U> LinkedList<U> fromArray(U[] array){
        if (array == null || array.length == 0) {
            return null;
        }
        LinkedList<U> linkedList = new LinkedList<>();
        for(U item : array) {
            linkedList.addLast(item);
        }

        return linkedList;
    }

    // Leet code: https://leetcode.com/problems/reverse-linked-list/
    public void reverse() {
        if(head == null) {
            // Empty list and nothing to reverse
            return;
        }

        Node<T> prev = null;
        Node<T> current = head;

        while(current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        tail = head;
        head = prev;
    }

    // Leet code: https://leetcode.com/problems/reverse-linked-list-ii/
    public void partialReverse(T left, T right) {
        if(head == null) {
            // Empty list and nothing to reverse
            return;
        }

        Node<T> startNode = null;
        Node<T> endNode = null;
        Node<T> current = head;
        Node<T> sub1Tail = null;
        Node<T> sub2Head = null;
        Node<T> prev = null;

        while(current != null) {
            if(current.data.equals(left)) {
                startNode = current;
                sub1Tail = prev;
            }

            if(current.data.equals(right)) {
                endNode = current;
                sub2Head = current.next;
                break;
            }
            prev = current;
            current = current.next;
        }

        if(startNode == null || endNode == null) {
            return;
        }

        // Break linked list;

        if (sub1Tail != null) {
            sub1Tail.next = null;
        }

        endNode.next = null;

        current = startNode;
        prev = null;

        while(current != null) {
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Join linked list

        if (sub1Tail == null) {
            head.next = sub2Head;
            head = prev;
        } else {
            sub1Tail.next = prev;
            startNode.next = sub2Head;
        }
    }
}
