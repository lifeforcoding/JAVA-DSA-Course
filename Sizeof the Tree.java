//Find the size of the binary tree
public static int getSize(TreeNode root) {
        if (root == null) return 0;
        int left = getSize(root.left);
        int right = getSize(root.right);
        return left + right + 1;
    }
