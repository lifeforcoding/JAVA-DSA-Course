public static int minTime(Node root, int target) {
        // Created for storing the combination of current node, and it's parent
        Map<Node, Node> map = new HashMap<>();
        //Function which will map the parent for each node and also return the address of the target node whose value is given only
        Node start = parentMapping(root, map, target);
        //Function to calculate and return the total time for burning the tree
        int time = totalTime(map, start);
        return time;
    }

    public static Node parentMapping(Node root, Map<Node, Node> map, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node start = null;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == target)
                start = current;
            if (current.left != null) {
                map.put(current.left, current);
                queue.add(current.left);
            }
            if (current.right != null) {
                map.put(current.right, current);
                queue.add(current.right);
            }
        }
        return start;
    }

    public static int totalTime(Map<Node, Node> map, Node start) {
        int max = 0;
        Map<Node, Integer> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        visited.put(start, 1);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int burnTime = 0;
            for (int i = 0; i< n; i++) {
                Node current = queue.poll();
                //If the left node is not null, and it is not present in the visited map then burn it and calculate time 1
                if (current.left != null && visited.get(current.left) == null) {
                    burnTime = 1;
                    visited.put(current.left, 1);
                    queue.offer(current.left);
                }
                //If the right node is not null, and it is not present in the visited map then burn it and calculate time 1
                if (current.right != null && visited.get(current.right) == null) {
                    burnTime = 1;
                    visited.put(current.right, 1);
                    queue.offer(current.right);
                }
                //If the parent node is not null, and it is not present in the visited map then burn it and calculate time 1
                if (map.get(current) != null && visited.get(map.get(current)) == null) {
                    burnTime = 1;
                    visited.put(map.get(current), 1);
                    queue.offer(map.get(current));
                }
            }
            if (burnTime == 1) max++;
        }
        return max;
    }
