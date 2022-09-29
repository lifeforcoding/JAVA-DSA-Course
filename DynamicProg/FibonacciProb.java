public int fib(int n) {
        Integer[] dp = new Integer[n];//DP array used for memorization
        return fibDp(n, dp);
    }
    public static int fibDp(int n, Integer[] dp) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (dp[n] != null) return dp[n]; // This condition is check if the fibonacci of current number is ascertained or not
        //if the nth fibo is ascertaining for 1st time then we have to fill the dp array
        return dp[n] = (fibDp(n - 1, dp) + fibDp(n - 2, dp));
    }
