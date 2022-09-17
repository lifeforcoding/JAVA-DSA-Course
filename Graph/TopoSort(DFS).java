static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfsTopo(adj, visited, stack, i);
            }
        }

        int[] ans = new int[V];
        for (int i = 0; i < V; i ++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
    public static void dfsTopo(ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack, int src) {
        visited[src] = true;
        for (Integer neighbour : adj.get(src)) {
            if (!visited[neighbour])
                dfsTopo(adj, visited, stack, neighbour);
        }
        stack.push(src);
    }
