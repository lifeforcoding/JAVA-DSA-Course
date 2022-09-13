//Implement Un Directional Graph using 2D Matrix.
class Graph {
    int[][] A;
    int n;// Denotes numbers of Nodes in a graph
    //Constructor for graph
    public Graph(int n) {
        this.n = n;
        A = new int[n][n];
    }

    //Function to add element in the graph
    public void addEdge(int src, int dst) {
        A[src][dst] = 1;
        A[dst][src] = 1;
    }
}
