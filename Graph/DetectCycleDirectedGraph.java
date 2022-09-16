public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] dfsVisited = new boolean[V];
        //Running this loop because the test cases may have different disconnected components
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsCycleDetect(i, adj, visited, dfsVisited)) return true;
            }
        }
        return false;
    }
    public static boolean dfsCycleDetect(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
        visited[src] = true;
        dfsVisited[src] = true;
        for (int neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                if (dfsCycleDetect(neighbour, adj, visited, dfsVisited)) return true;
            }
            //When both the position in a current traversal is marked as visited then there is a cycle present
            else if (dfsVisited[neighbour]) return true;
        }
        //Every time we go back we mark the dfsvisited as un visit because it is to be utilised for another traversal
        dfsVisited[src] = false;
        return false;
    }
