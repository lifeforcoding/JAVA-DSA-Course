class Graph{
    ArrayList<ArrayList<Integer>> A;
    int n;

    public Graph(int n) {
        this.n = n;
        for (int i = 0; i < n; i++)
            A.add(new ArrayList<>());
    }

    public void addEdge(int src, int dst) {
        A.get(src).add(dst);
        A.get(dst).add(src);
    }
    //Traverse the graph in dfs
    public void dfs(int src, boolean[] visited, ArrayList<Integer> ans) {
        ans.add(src);
        visited[src] = true;
        for (Integer neighbour : A.get(src)) {
            if (!visited[neighbour])
                dfs(neighbour, visited, ans);
        }
    }

    //Bfs traversal
    public void bfs(int src, boolean[] visited, ArrayList<Integer> ans) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int crr = q.poll();
            ans.add(crr);
            for (Integer neighbour : A.get(crr)) {
                if (!visited[neighbour]) {
                    q.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }
}
