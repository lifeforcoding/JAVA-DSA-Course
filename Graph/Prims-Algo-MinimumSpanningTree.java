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

//Implementing Prim's Algo for finding the minimum spanning tree of a given undirected weighted graph
    public int[] minSpan(ArrayList<ArrayList<Pair>> adj, int n) {
        int[] key = new int[n]; // Holds the minimum length to reach to this node
        boolean[] isSpan = new boolean[n];
        int[] parent = new int[n]; //Hold the parent address of all node in a spanning tree

        //Initialize the 3 array
        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            isSpan[i] = false;
            parent[i] = -1;
        }
        key[0] = 0;

        for (int i = 0; i < n-1; i++) {
            //find the minimum possible key value which is not in the spanning tree
            int minimumValue = Integer.MAX_VALUE;
            int u = 0;
            for (int j = 0; j < key.length; j++) {
                if (isSpan[i] ==  false && key[j] < minimumValue) {
                    minimumValue = key[j];
                    u = j;
                }
                isSpan[u] = true; // Include the minimum key value node to the spanning tree

                //finding the adjacency nodes of the minimum value node and updating them with the minimum weight to reach them
                // Also updating their parent
                for (Pair neighbour : adj.get(u)) {
                    //If the adjacency node not present in spanning tree and it's key value is greater then it's current weight
                    //Then update it's key value with it's current weight and mark it's parent as u
                    if (!isSpan[neighbour.getV()] && neighbour.getWeight() < key[neighbour.getV()]) {
                        key[neighbour.getV()] = neighbour.getWeight();
                        parent[neighbour.getV()] = u;
                    }
                }
            }
        }
        return parent;
    }
