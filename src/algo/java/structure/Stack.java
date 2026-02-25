package algo.java.structure;

import java.util.ArrayList;

public class Stack<T> {

    private final ArrayList<T> data;

    public Stack() {
        data = new ArrayList<>();
    }
    public void push(T item) {
        data.add(item);
    }

    public T pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.removeLast();
    }

    public T peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data.getLast();
    }

    public int size() {
        return data.size();
    }
}
