 //Return the maximum coins you can collect by bursting the balloons wisely
    public static int maxCoins(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n + 1][n + 1]; // DP Array for memoization
        //Creating a new array and put 1 in both the boundary of the given array
        int[] num = new int[n + 2];
        System.arraycopy(nums, 0, num, 1, n);
        num[0] = num[num.length - 1] = 1;
        return brustBaloon(num, 1, n, dp);
    }
    public static int brustBaloon(int[] num, int start, int end, Integer[][] dp) {
        if (start > end) return 0;
        if (dp[start][end] != null) return dp[start][end];

        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int cost = Math.max(max, num[start - 1] * num[i] * num[end + 1] + brustBaloon(num, start, i - 1, dp)
                    + brustBaloon(num, i + 1, end, dp));
            max = Math.max(max, cost);
        }
        return dp[start][end] = max;
    }
