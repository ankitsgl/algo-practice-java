package algo.java.structure;

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


    private class Node<T> {
        public T data; 
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
