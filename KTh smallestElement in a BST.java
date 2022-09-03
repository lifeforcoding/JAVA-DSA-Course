public int kthSmallest(TreeNode root, int k) {
        TreeNode ans = kthSmallest(root, new int[]{k});
        return ans.val;
    }
    public static TreeNode kthSmallest(TreeNode root, int[] k) {
        if (root == null) return null;
        TreeNode left = kthSmallest(root.left, k);
        if (left != null) return left;
        k[0]--;
        if (k[0] == 0) return root;
        return kthSmallest(root.right, k);
    }
