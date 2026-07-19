package datastructures;

public class MyQueue<T> {

    private MyLinkedList<T> queue;

    public MyQueue() {
        queue = new MyLinkedList<>();
    }

    // Add element
    public void enqueue(T data) {
        queue.addLast(data);
    }

    // Remove element
    public T dequeue() {
        return queue.removeFirst();
    }

    // View front element
    public T peek() {
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}