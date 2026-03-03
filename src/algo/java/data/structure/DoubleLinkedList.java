package algo.java.data.structure;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void addAll(T... dataArray) {
        for (T data : dataArray) {
            addLast(data);
        }
    }
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node; 
            head = node;
        }
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public T removeFirst() {
        // Nothing in list
        if (head == null) {
            return null;
        }

        // Only one node in list;
        if (head == tail) {
            T data = head.data;
            head = tail = null;
            return data;
        }
        T data = head.data;
        head = head.next;
        head.prev = null;
        return data;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        }

        if (head == tail) {
            T data = tail.data;
            head = tail = null;
            return data;
        }

        T data = tail.data;
        tail = tail.prev;
        tail.next = null;
        return data;
    }

    public void remove(T data) {
        Node<T> current = head;
        while(current != null) {
            if (current.data.equals(data)) {
                break;
            }
            current = current.next;
        }
        if (current == null) {
            // No matching record found
        } else  if (current == head) {
            removeFirst();
        } else if (current == tail) {
           removeLast();
        } else {
            // Remove in middle;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    public void clear() {
        head = tail = null;
    }

    public void print() {
        Node<T> current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print("%s<->".formatted(current.data));
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
            sb.append("%s<->".formatted(current.data));
            current = current.next;
        }
        sb.append("]");

        return sb.toString();
    }

    private class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}
