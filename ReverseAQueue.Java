public Queue<Integer> rev(Queue<Integer> q){
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        while (!q.isEmpty())
            temp.addFirst(q.poll());
        while (!temp.isEmpty())
            q.offer(temp.pop());
        return q;
    }
