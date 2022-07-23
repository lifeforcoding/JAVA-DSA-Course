static long minTime(int[] arr,int n,int k){
        int low = 0, high = 0;
        //low hold the value of the highest length board while high will hold the length of all the board
        for (int e : arr) {
            high += e;
            low = Math.max(low, e);
        }
        long ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isFeasible(arr, mid, k)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    //Function to check if the k time is possible to get job done by n no of worker
    public static boolean isFeasible(int[] arr, int time, int n) {
        int count = 1;
        int totalTime = 0;
        for (int e : arr) {
            if (totalTime + e <= time) {
                totalTime += e;
            }
            else {
                totalTime = e;
                count++;
            }
        }
        return count <= n;
    }
