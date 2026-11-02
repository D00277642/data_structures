package b_list.utils;

public class LinkedBasedQueue {
    private String[] queue;
    int size = 0;

    public LinkedBasedQueue() {
        queue = new String[10];
    }

    public void enqueue(String item) { //enqueue(e) insert at the end
        queue[size] = item;
        size++;
    }

    public String dequeue() { //dequeue() remove
        String item = queue[0];

        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }

        size--;
        return item;
    }

    public boolean isEmpty() {//isEmpty() checks if queue is empty
        return size == 0;
    }
}
