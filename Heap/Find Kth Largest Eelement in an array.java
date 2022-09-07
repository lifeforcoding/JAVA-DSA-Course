public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0;
  //Put the 1st k element into the priority queue
        while (i < k) {
            pq.offer(nums[i]);
            i++;
        }
  //Check other remaining element with the minheap head node if 
  //It is greater then the peek then remove the peek and add the current element into the heap
        while (i < nums.length) {
            if (!pq.isEmpty() && pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
            i++;
        }
  //Return the peek of the min heap
        return pq.peek();
    }
