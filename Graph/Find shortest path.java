//Find the shortest path from the 0 node to the given destination node
public static int findMinDis(ArrayList<ArrayList<Integer>> adj, int V, int src, int dst) {
        int[] dis = new int[V];
        boolean[] visited = new boolean[V];

        bfs(0, adj, dis, visited);
        return dis[dst];
    }
    //Modified bfs for find the distance
    public static void bfs(int src, ArrayList<ArrayList<Integer>> adj, int[] distance, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        distance[src] = 0;
        visited[src] = true;

        while (!q.isEmpty()) {
            int crr = q.poll();
            for (Integer neighbour : adj.get(crr)) {
                if (!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                    distance[neighbour] = distance[crr] + 1;
                }
            }
        }
    }
