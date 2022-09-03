public  static int findCeil(TreeNode<Integer> root, int x) {
        int ceil = -1;
        while (root != null) {
            if (root.val == x) {
                ceil = root.val;
                return ceil;
            }
            //If key is greater than root.val
            if (x > root.val)
                root = root.right;
            else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
