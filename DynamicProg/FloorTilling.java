static Long numberOfWays(int N) {
        if(N<=2)
            return Long.valueOf(N);
        long[] dp = new long[N + 1];
  //Initialise the DP for size 0, 1 & 2
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 2L;
        for (int i = 3; i <= N; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007; //Return the answer as modular of 10^9 + 7
        return dp[N];
    }
