//Print all nodes in distance k from a target node
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentInfo = new HashMap<>();
        markParent(root, parentInfo);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == k) break;
            currentLevel++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parentInfo.get(current) != null && visited.get(parentInfo.get(current)) == null) {
                    queue.offer(parentInfo.get(current));
                    visited.put(parentInfo.get(current), true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty())
            ans.add(queue.poll().val);
        return ans;
    }
    public static void markParent(TreeNode root, Map<TreeNode, TreeNode> parentInfo) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
                parentInfo.put(current.left, current);
            }
            if (current.right != null) {
                queue.offer(current.right);
                parentInfo.put(current.right, current);
            }
        }
    }
}
