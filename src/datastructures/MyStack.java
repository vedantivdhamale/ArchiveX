package datastructures;

public class MyStack<T> {

    private MyLinkedList<T> stack;

    public MyStack() {
        stack = new MyLinkedList<>();
    }

    public void push(T data) {
        stack.addLast(data);
    }

    public T pop() {
        return stack.removeLast();
    }

    public T peek() {
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}