public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        distance(root, max);
        return max[0];
    }
    public static int distance(TreeNode root, int[] max) {
        if (root == null) return 0;

        int leftHeight = distance(root.left, max);
        int rightHeight = distance(root.right, max);
        //Update the max with the total (lh + rh) with himself using math.max
        //This step represents storing the distance from left end to right end of the current node
        max[0] = Math.max(max[0],leftHeight+rightHeight);

        return 1+Math.max(leftHeight,rightHeight);
    }
