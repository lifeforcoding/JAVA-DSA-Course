public static ArrayList<Integer> printNearNodes(Node root,int low,int high) {
        ArrayList<Integer> ans = new ArrayList<>();
        printNearNodes(root, low, high, ans);
        return ans;
    }
    public static void printNearNodes(Node root, int low, int high, ArrayList<Integer> ans) {
        if (root == null) return;
        if (low < root.data)
            printNearNodes(root.left, low, high, ans);
        if (low <= root.data && high >= root.data)
            ans.add(root.data);
        if (high > root.data)
            printNearNodes(root.right, low, high, ans);
    }
