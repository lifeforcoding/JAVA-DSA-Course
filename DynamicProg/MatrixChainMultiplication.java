static int matrixMultiplication(int N, int[] arr) {
            Integer[][] dp = new Integer[N][N]; // DP array for memoization
            return helper(1, N - 1, arr, dp);
    }

    public static int helper(int i, int j, int[] arr, Integer[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int minValue = Integer.MAX_VALUE;
        // Here k will partition the array for multiplication starting from k = 1  to k + 1 to j
        for (int k = i; k < j; k++) {
            //On each iteration we calculate the steps for current partition and call recursively to calculate the steps for element in
            // Both the 2 partition which is 1 to k and k + 1 to j
            int multiplySteps = arr[i - 1] * arr[k] * arr[j] + helper(i, k, arr, dp) + helper(k + 1, j, arr, dp);
            minValue = Math.min(multiplySteps, minValue);
        }
        return dp[i][j] = minValue;
    }
