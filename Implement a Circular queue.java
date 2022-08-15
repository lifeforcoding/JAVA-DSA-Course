class MyCircularQueue {
    int[] a;
    int first, rear;
    public MyCircularQueue(int k) {
        a = new int[k];
        first = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        if (isEmpty()) {
            first = rear = 0;
            a[rear] = value;
            return true;
        }
        //For circular implementation
        rear = (rear + 1) % a.length;
        a[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (first == rear) {
            first = -1;
            rear = -1;
            return true;
        }
        first = (first + 1) % a.length;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return a[first];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return a[rear];
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public boolean isFull() {
        return (rear + 1) % a.length == first;
    }
}
