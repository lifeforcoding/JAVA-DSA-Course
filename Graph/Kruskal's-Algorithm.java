class Pair implements Comparable<Pair>{
    int weight;
    int u;
    int v;
    public Pair(int weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }
    public int getWeight() {
        return weight;
    }
    public int getU() {
        return u;
    }
    public int getV() {
        return v;
    }
    //Implements comparable and override it's function so that we can sort arraylist of pair
    @Override
    public int compareTo(Pair o2) {
        if (this.getWeight() < o2.getWeight())
            return -1;
        else if (this.getWeight() > o2.getWeight())
            return 1;
        return 0;
    }
}
public class DSA {
    public static void main(String[] args) {

    }
    //Implementing kruskal's algo for extract minimum spanning tree from a given undirected graph.
    public static ArrayList<Pair> minSpanningTree(ArrayList<Pair> adj, int n) {
        Collections.sort(adj);
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i ++) {
            parent[i] = i;
            rank[i] =  0;
        }
        //Traversing all the sorted by weight adjacency node nad creating a MST in an arraylist
        ArrayList<Pair> mst = new ArrayList<>();
        for (Pair crr : adj) {
            if (!areInASet(crr.getU(), crr.getV(), parent)) {
                union(crr.getU(), crr.getV(), rank, parent);
                mst.add(crr);
            }
        }
        return mst;
    }
    //function to check if 2 point are in same set or not
    public static boolean areInASet(int a, int b, int[] parent) {
        return (findParent(a, parent) == findParent(b, parent));
    }
    //Implementing union by rank property of disjoint set
    public static void union(int a, int b, int[] rank, int[] parent) {
        int parentA = findParent(a, parent);
        int parentB = findParent(b, parent);

        if (rank[parentA] < rank[parentB])
            parent[a] = parentB;
        else if (rank[parentA] > rank[parentB])
            parent[b] = parentA;
        else {
            parent[b] = a;
            rank[parentA]++;
        }
    }
    //Implementing find parent function using property path compression
    public static int findParent(int i, int[] parent) {
        if (i == parent[i]) return i;

        return parent[i] = findParent(parent[i], parent);
    }
}
