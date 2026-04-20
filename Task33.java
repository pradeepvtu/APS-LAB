class MyCircularQueue {
    private int[] queue;
    private int head;
    private int count;
    private int capacity;

    /** Initializes the object with the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.head = 0;
        this.count = 0;
    }
    
    /** Inserts an element into the circular queue. Return true if successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        // Calculate the next available position using modulo
        int tail = (head + count) % capacity;
        queue[tail] = value;
        count++;
        return true;
    }
    
    /** Deletes an element from the circular queue. Return true if successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        // Move the head forward and reduce the count
        head = (head + 1) % capacity;
        count--;
        return true;
    }
    
    /** Gets the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }
    
    /** Gets the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        // Tail is the position (head + count - 1)
        int tail = (head + count - 1) % capacity;
        return queue[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}
