package algo.java.data.structure;

import java.util.ArrayList;

public class Queue<T> {

    private final ArrayList<T> data;

    public Queue() {
        data = new ArrayList<>();
    }
    public void enqueue(T item) {
        data.add(item);
    }

    public T dequeue() {
        if (data.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data.removeFirst();
    }

    public T peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data.getFirst();
    }

    public int size() {
        return data.size();
    }
}
