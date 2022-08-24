class pair {
    int hd;
    Node node;
    pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
  }
public class Practice {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> topView(Node root)
    {
        //Storing the current node and horizontal position in a pair in the queue
        Queue<pair> queue = new LinkedList<pair>();
        //Treemap for storing the unique value for each hd position if it doesn't exist in
        // a manner of position and node value
        Map<Integer, Integer> map = new TreeMap<>();
        //Adding the root node, and it's hd(Horizontal distance position in the queue)
        queue.add(new pair(root,0));
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                pair current = queue.poll();
                int hd = current.hd;
                Node node = current.node;
                //Putting the current node data with the hd if there is not any element at that position not available
                if (!map.containsKey(hd)) {
                    map.put(hd, node.data);
                }
                if (node.left != null) {
                    queue.add(new pair(node.left, hd - 1));
                }
                if (node.right != null) {
                    queue.add(new pair(node.right, hd + 1));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            ans.add(entry.getValue());
        return ans;
    }
