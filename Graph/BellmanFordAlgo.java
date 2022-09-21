class Pair {
    int u;
    int v;
    int weight;
    public Pair (int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }
    public int getV() {
        return v;
    }
    public int getWeight() {
        return weight;
    }
}
//Implementing the bellman ford algo which will find the shortest path from source to all node in a graph with negative weight
    //This algo will also help in finding the is negative cycle present in a weighted directed graph
    public int[] bellFord(ArrayList<Pair> adj, int N, int src) {
        int[] distance = new int[N];
        //filling the whole distance array with the infinite value
        for (int i = 0; i < N; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0; //updating the distance of source to zero

        //Relaxing the graph by N - 1 time
        for (int i = 0; i < N -1; i++) {
            for (Pair crr : adj) {
                if (distance[crr.getU()] + distance[crr.getWeight()] < distance[crr.getV()])
                    distance[crr.getV()] = distance[crr.getU()] + distance[crr.getWeight()];
            }
        }

        //After iterating for N- 1 times again iterate for 1 more time if the value of the distance array further decrease
        //Than there is a negative cycle present int the graph and shortest path can't be found
        for (Pair crr : adj) {
            if (distance[crr.getU()] + distance[crr.getWeight()] < distance[crr.getV()]) {
                System.out.println("Negative Cycle present ");
                break;
            }
        }
        return distance;
    }
