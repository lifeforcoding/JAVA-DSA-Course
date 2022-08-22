//Find the maximum and minimum node value in a binary tree
public static int findMax(TreeNode root){
        if (root == null) return 0;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }
    public static int findMin(TreeNode root){
        if (root == null) return Integer.MAX_VALUE;
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
