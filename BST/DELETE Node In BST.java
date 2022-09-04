public TreeNode deleteNode(TreeNode root, int key) {
        if (root ==null) return null;

        if (key < root.val)
            root.left = deleteNode(root.left, key);

        else if (key > root.val)
            root.right = deleteNode(root.right, key);
        else {
            //If there is only right subtree of to delete node
            if (root.left == null)
                return root.right;
                //If there is only subtree of to delete node
            else if (root.right == null)
                return root.left;
            //If the to delete node has both right and left subtree
            root.val = root.right.val;
            /*If the to delete node left right element is null then we directly attach the
            delete ode right left node to it, otherwise we have to find out the last of the to delete left right
            subtree and attach the node at leaf*/

            if (root.left.right == null)
                root.left.right = root.right.left;
            else {
                TreeNode lastPoint = findLastPoint(root.left.right);
                lastPoint.right = root.right.left;
            }
            root.right = root.right.right;
        }
        return root;
    }

    public static TreeNode findLastPoint(TreeNode root) {
        TreeNode crr = root;
        while (crr.right != null)
            crr = crr.right;
        return crr;
    }
