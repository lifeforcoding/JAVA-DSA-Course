//split the array into k subarray such that the maximum sum of an array is minimum
    static int solve(int array[], int n, int K) {
        Arrays.sort(array);
        int i = n -1;
        Queue<Integer> pq = new PriorityQueue<>();
        while (i >= (n - K))
            pq.offer(array[i++]);
        for (; i >= 0; i--) {
            int top = pq.poll();
            pq.offer(array[i] + top);
        }
        int max = -1;
        for (int e : pq)
            max = Math.max(max, e);
        return max;
    }
