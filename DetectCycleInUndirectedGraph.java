//Detect cycle in a unweighted undireted graph
public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        //Running this loop because the test cases may have different connected components
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                //Initial parent for each connected component is -1
                if (dfsCycle(i, adj, visited, -1)) return true;
        }
        return false;
    }
    public static boolean dfsCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[src] = true;
        for (Integer neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                if (dfsCycle(neighbour, adj, visited, src)) return true;
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
