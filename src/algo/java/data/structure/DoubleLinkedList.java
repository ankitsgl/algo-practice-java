package algo.java.data.structure;

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    // Idea: to simplify logic, we can use dummy head and tail node, 
    // so that we don't need to check for null when adding or removing nodes.

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void addAll(T... dataArray) {
        for (T data : dataArray) {
            addLast(data);
        }
    }
    public Node<T> addFirst(T data) {
        return addFirst(new Node<>(data));
    }

    public Node<T> addFirst(Node<T> node) {
        node.prev = node.next;
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node; 
            head = node;
        }
        return node;
    }

    public Node<T> addLast(T data) {
        return addLast(new Node<>(data));
    }
    public Node<T> addLast(Node<T> node) {
        node.prev = node.next;
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        return node;
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
        } else {
            removeNode(current);
        }
    }

    public void removeNode(Node<T> node) {
        if (node == head) {
            removeFirst();
        } else if (node == tail) {
            removeLast();
        } else {
            // Remove in middle;
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public void moveToHead(Node<T> node) {
        removeNode(node);
        addFirst(node);
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
}
