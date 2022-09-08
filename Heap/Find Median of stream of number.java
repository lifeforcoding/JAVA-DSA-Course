class MedianFinder {
    Queue<Integer> maxHeap, minHeap;
    boolean even;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        //If element in both the heap is evenly distributed then we have to put that in to the max heap on left
        //But 1st we put that into min heap then remove the peak element from minheap and add in the max heap
        //Because the above step will help in skip the requirement for, the number stream is to be sorted,
        if (even) {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        else {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }
        //Switch the even var after each insertion
        even = !even;
    }

    public double findMedian() {
        if (even)
            return ((maxHeap.peek() + minHeap.peek()) / 2.0);
        else return (double)maxHeap.peek();
    }
}
