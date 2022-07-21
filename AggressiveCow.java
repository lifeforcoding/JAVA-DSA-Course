//Assign k no of cows in the n no of co-ordinates such that minimum distance between any
    //two of them is as large as possible.
    public static int aggCow(int[] stalls, int n, int k) {
        //Let suppose the maximum distance that should be minimum = 1;
        int low = 1;
        //The maximum distance should be distance between the last stall and 1st stall
        int high = stalls[n - 1] - stalls[0];
        //Loop to check which distance should be appropriate as per the condition
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(stalls, n, k, mid)) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }

    //Function to check if we can put the cows in the given distance
    public static boolean isPossible(int[] stalls, int n, int k, int mid) {
        int count = 1;
        int stall = stalls[0];
        for (int i = 1; i < n; i++) {
            //If the distance is equal or greater than the appropriate distance then
            if (stalls[i] - stall >= mid) {
                count++;
                stall = stalls[i];
            }
        }
        return count == k;
    }
