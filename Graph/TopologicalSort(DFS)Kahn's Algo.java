static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = indegree(adj,V);
        Queue<Integer> q = new LinkedList<>();
        //Putting all the 0 In degree component in the queue
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }
        //pointer for ans array
        int count = 0;
        int[] ans = new int[V];
        while (!q.isEmpty()) {
            Integer current = q.poll();
            ans[count++] = current;

            for (Integer neighbour : adj.get(current)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    q.add(neighbour);
            }
        }
        return ans;
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
