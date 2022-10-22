static long countMaximum(int arr[], int n) {
        Long[][] dp = new Long[n][n];
        return countMaxHelper(0 ,n - 1, arr, dp);
    }

    public static long countMaxHelper(int begin, int end, int[] arr, Long[][] dp) {
        if (begin > end) return 0;

        if (dp[begin][end] != null) return dp[begin][end];
        // At 1st the user will pick the max of the 2 end because the oppenent is also as intelligent as user next time he will also make the user such that
        // he will get the lowest of the 2 end
        //Scenario if we choose the begin element
        long x = arr[begin] + Math.min(countMaxHelper(begin + 1, end - 1, arr, dp), countMaxHelper(begin + 2, end, arr, dp));
        //Scenario if we choose the end element
        long y = arr[end] + Math.min(countMaxHelper(begin + 1, end - 1, arr, dp), countMaxHelper(begin, end - 2, arr, dp));

        return dp[begin][end] = Math.max(x,y);
    }
