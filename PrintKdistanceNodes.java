//Print all the nodes in k distance from the node
public static void printKDistanceNodes(TreeNode root, int k) {
        //Base case for printing when the k is 0
        if (root == null || k < 0) return;
        if (k == 0) {
            System.out.println(root.val);
            return;
        }
        //Calling for recursive function for left part of the root
        printKDistanceNodes(root.left, k - 1);
        //Calling for recursive function for right part of the root
        printKDistanceNodes(root.right, k -1);
    }
