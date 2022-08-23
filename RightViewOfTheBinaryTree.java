public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //Keep the record of queue size so that we can traverse al the element of that level using a loop
            int n = queue.size();
            //Loop for traversing al the element of a level
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                //if this is the last element in the queue of n size then add the value of that node to ans.
                if (i == n - 1) {
                    ans.add(current.val);
                }
                //1st store the left node of the root then the right node
                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
        }
        return ans;
    }
