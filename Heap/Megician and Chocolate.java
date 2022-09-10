public static int maximumChocolates(ArrayList<Integer> arr, int k){
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer : arr)
            pq.offer(integer);
        int i = 0;
        int ans = 0;
        while (i < k && !pq.isEmpty()) {
            int peek = pq.poll();
            ans += peek;
            peek = (int)Math.floor(peek / 2);
            pq.offer(peek);
            i++;
        }
        long modulo = (long) Math.pow(10,9)  + 7;
        return (int)(ans % modulo);
    }
