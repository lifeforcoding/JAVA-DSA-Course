public boolean validPath(int n, int[][] edges, int source, int destination) {
        //Convert the 2d array to adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        distance[source] = 0;
        dfsPath(adj, source, visited, distance);
        //if the destination is not updated after the call of dfs from the source then there is no link between src to dst and return false
        return distance[destination] >= 0;
    }
    //dfs traversal and updating the distance array with distacne from source
    public static void dfsPath(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, int[] distance) {
        visited[src] = true;
        for (int neighbour : adj.get(src)) {
            if (!visited[neighbour]) {
                distance[neighbour] = distance[src] + 1;
                dfsPath(adj, neighbour, visited, distance);
            }
        }
    }
