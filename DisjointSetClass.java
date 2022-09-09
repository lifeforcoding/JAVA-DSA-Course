//Defining Disjoint Set Class using union by rank and path compression properties
class DisjointSet {
    int[] parent;
    int[] rank;
    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        //Initialize the parent array with self because they are their own parent at this point
        //And initialize the rank array with zero because no element is connected to any other at this point
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int findParent(int n) {
        if (parent[n] == n) return n;

        return parent[n] = findParent(parent[n]); //This is the path compression property
    }

    //Function for union of 2 individuals
    public void union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (rank[parentA] < rank[parentB]) {
            parent[a] = parentB;
        } else if (rank[parentA] > rank[parentB]) {
            parent[b] = parentA;
        }
        else {
            parent[b] = a;
            rank[a]++;
        }
    }
    //Check if 2 individuals are present in a set
    public boolean areInSet(int a, int b) {
        return (findParent(a) == findParent(b));
    }
}
