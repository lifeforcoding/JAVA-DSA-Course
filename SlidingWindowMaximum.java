public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int p = 0; //Points to the index in the ans array.
        for (int i = 0; i < n; i++) {
            //Condition for deleting the element from front of the queue which is out of bound of k range
            if (!dq.isEmpty() && dq.peek() == i - k)
                dq.removeFirst();
            //Condition for removing all the smaller element index from the i th element of the array from the deque
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            //Inserting the current element in the queue
            dq.addLast(i);
            if (!dq.isEmpty() && i >= k - 1) {
                ans[p++] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
