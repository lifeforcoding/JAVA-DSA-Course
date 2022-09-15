static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        //Converting to adjacency list because input is given in adjacency matrix
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj.get(i).get(j) == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        //Code if input is given in list
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                dfs(i,visited,adjList);
            }
        }
        return count;
    }
    public static void dfs(int src, boolean[] visited, ArrayList<ArrayList<Integer>> A) {
        visited[src] = true;
        for (Integer neighbour : A.get(src)) {
            if (!visited[neighbour])
                dfs(neighbour, visited, A);
        }
    }
