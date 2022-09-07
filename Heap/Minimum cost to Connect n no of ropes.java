long minCost(long arr[], int n) 
    {
        Queue<Long> pq = new PriorityQueue<>();
        for (long e : arr)
            pq.offer(e);
            long total = 0;
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            long cost = first + second;
            pq.offer(cost);
            total += cost;
        }
        return total;
    }
