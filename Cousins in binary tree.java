public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean xExist = false;
            boolean yExist = false;
            for (int i = 0; i < n; i ++) {
                TreeNode current = queue.poll();
                // If x exist in the traversal level then mark x exist as true
                if (current.val == x)
                    xExist = true;
                // If y exist in the traversal level then mark y exist as true
                if (current.val == y)
                    yExist = true;
                if (current.left != null && current.right != null) {
                    //condition to check if current left value == current right value then return false
                    if (current.left.val == x && current.right.val == y)
                        return false;
                    if (current.right.val == x && current.left.val == y)
                        return false;
                }
                //Conditions to put child of current if it is nu=ot null
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
            if (xExist && yExist)
                return true;
        }
        return false;
    }
