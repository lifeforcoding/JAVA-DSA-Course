//Level order traversal in a binary tree
public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //Null will partition the elements in the queue by their level
        // If null occurs during traversal then there is complete traversal of the level.
        queue.offer(null);
        List<Integer> currentList = new ArrayList<>();
        while (!queue.isEmpty()) {
                TreeNode current = queue.poll();
                if (current == null) {
                    ans.add(currentList);
                    if (queue.isEmpty()) return ans;
                    queue.offer(null);
                    currentList = new ArrayList<>();
                }
                else {
                    currentList.add(current.val);
                    if (current.left != null) {
                        queue.offer(current.left);
                    }
                    if (current.right != null) {
                        queue.offer(current.right);
                    }
                }
