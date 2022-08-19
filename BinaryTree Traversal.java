    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        traverse(root, ans);
        return ans;
    }
// Inorder traversal of a Binary tree
    public void traverse(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        traverse(root.left, ans);
        ans.add(root.val);
        traverse(root.right, ans);
    }

//preorder traversal of a binary tree
public void traverse(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        ans.add(root.val);
        traverse(root.left, ans);
        traverse(root.right, ans);
    }
//Post order traversal
public void traverse(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        traverse(root.left, ans);
        traverse(root.right, ans);
        ans.add(root.val);
    }
