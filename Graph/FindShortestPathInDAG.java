//Find shortest path from 0 to all node in a Directed acyclic graph
class Pair {
    int V;
    int weight;
    public Pair(int V, int weight) {
        this.V = V;
        this.weight = weight;
    }
    public int getV() {
        return V;
    }
    public int getWeight() {
        return weight;
    }
}

public static int[] shortPathDAG(ArrayList<ArrayList<Pair>> adj, int V, int src) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfsTopo(adj, visited, stack, i);
        }
        int[] distance = new int[V];
        //Initialise the array with max value which can't be the answer
        for (int i = 0 ; i < V; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (distance[current] != Integer.MAX_VALUE) { // Condition to check if we already reached to the not or not
                for (Pair crr : adj.get(current)) {
                    //If the source node distance + the weight for the current distance is lesser than the current node distance value then update the current node distance
                    if (distance[current] + crr.getWeight() < distance[crr.getV()])
                        distance[crr.getV()] = distance[current] + crr.getWeight();
                }
            }
        }
        return distance;
    }
    //Topological sort using dfs function
    public static void dfsTopo(ArrayList<ArrayList<Pair>> adj, boolean[] visited, Stack<Integer> stack, int src) {
        visited[src] = true;
        for (Pair neighbour : adj.get(src)) {
            if (!visited[neighbour.getV()])
                dfsTopo(adj, visited, stack, neighbour.getV());
        }
        stack.push(src);
    }
