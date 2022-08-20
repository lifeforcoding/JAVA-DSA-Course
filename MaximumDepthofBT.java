public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        //Calculate the left height
        int lh = maxDepth(root.left);
        //Calculate the right height
        int rh = maxDepth(root.right);
        //Return the max of the 2 height + 1
        return Math.max(lh,rh) + 1;
    }
