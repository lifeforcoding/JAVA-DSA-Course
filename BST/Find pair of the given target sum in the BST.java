public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, k, new HashSet<Integer>());
    }
    public boolean findTarget(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        //Traverse in Inorder manner
        if (findTarget(root.left, k, set))
            return true;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.right, k, set);
    }
