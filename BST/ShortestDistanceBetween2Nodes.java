public static int distanceBetween2(TreeNode root, int a, int b) {
        if (root == null) return 0;
        //If both the value is lesser than the root then go for left
        if (root.val > a && root.val > b)
            return distanceBetween2(root.left, a, b);
        // If both the value greater than the root then go for right
        if (root.val < a && root.val < b)
            return distanceBetween2(root.right, a, b);
        // Condition if both the part falls in both side of the root. then calculate distance from root to that left point and to that right point
        // Then return by simply adding both the distance
        if (root.val > a && root.val < b)
            return (distanceFromRoot(root, a) + distanceFromRoot(root, b));
        return 0;
    }
    public static int distanceFromRoot(TreeNode root, int target) {
        if (root == null) return 0;
        if (root.val > target)
            return 1 + distanceFromRoot(root.left, target);
        return 1 + distanceFromRoot(root.right, target);
    }
