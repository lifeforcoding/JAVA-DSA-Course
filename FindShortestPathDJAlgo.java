//Find shortestpath in undirected weighted graph using dijesktra's algo
public static int[] shortestPath(ArrayList<ArrayList<Pair>> adj, int V, int src) {
        int[] distance = new int[V];
        for (int i = 0; i < V; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[src] = 0;
        //Using Lambdas instead of implementing comparator interface for comparing the custom class and storing it in minheap Priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p1.getWeight() - p2.getWeight());
        pq.add(new Pair(src,0));
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            for (Pair neighbour: adj.get(current.getV())) {
                if (distance[current.getV()] + neighbour.getWeight() < distance[neighbour.getV()]) {
                    distance[neighbour.getV()] = distance[current.getV() + neighbour.getWeight()];
                    pq.add(new Pair(neighbour.getV(), distance[neighbour.getV()]));
                }
            }
        }
        return distance;
    }
