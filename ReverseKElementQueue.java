public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        int i = 0;
        while (i < k && !q.isEmpty()) {
            temp.addFirst(q.poll());
            i++;
        }
        while (!temp.isEmpty())
            q.add(temp.pop());
        i = 0;
        int n = q.size();
        while (i < (n - k)) {
            int m = q.poll();
            q.add(m);
            i++;
        }
        return q;
    }
