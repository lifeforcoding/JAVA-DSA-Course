//Tree cutter problem
    public static int sizeOFSaw(ArrayList<Integer> A, int b) {
        int low = 0;
        //Find the high which will be the tallest length tree among the array of tree
        int high = max(A);
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // condition to check length is appropriate
            if (isPossible(A, b, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
    public static boolean isPossible(ArrayList<Integer> A, int b, int cut) {
        int totalCutLength = 0;
        for (int e : A) {
            if (e > cut)
                totalCutLength += (e - cut);
        }
        return totalCutLength >= b;
    }
    public static int max(ArrayList<Integer> n) {
        int ans = 0;
        for (int e : n) {
            if (e > ans)
                ans = e;
        }
        return ans;
    }
