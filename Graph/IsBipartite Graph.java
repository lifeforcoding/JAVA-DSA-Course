 public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        //Initialize the color array with -1
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1)
                if (!dfsCheck(graph, color, i))
                    return false;
        }
        return true;
    }

    public static boolean dfsCheck(int[][] graph, int[] color, int src) {
        for (int neighbour : graph[src]) {
            if (color[neighbour] == -1) {
                color[neighbour] = 1 - color[src];
                if (!dfsCheck(graph, color, neighbour))
                    return false;
            } else if (color[neighbour] == color[src])
                return false;
        }
        return true;
    }
