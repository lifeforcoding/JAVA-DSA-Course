public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = indegree(adj,V);
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        //Putting all the 0 In degree component in the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                count++;
            }
        }
        //pointer for ans array
        
        while (!q.isEmpty()) {
            Integer current = q.poll();
            for (Integer neighbour : adj.get(current)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    q.add(neighbour);
                    count++;
                }
            }
        }
        return (count < V);
    }
    public static int[] indegree(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] indeg = new int[V];
        for (ArrayList<Integer> a : adj) {
            for (Integer n : a) {
                indeg[n]++;
            }
        }
        return indeg;
    }
