public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    public static TreeNode bstFromPreorder(int[] arr, int bound, int[] index) {
        if (index[0] == arr.length || arr[index[0]] > bound) return null;
        TreeNode root = new TreeNode(arr[index[0]++]);

        root.left = bstFromPreorder(arr, root.val, index);
        root.right = bstFromPreorder(arr, bound, index);
        return root;
    }
