//The formula will be n! / r! * (n-r)!
static int nCr(int n, int r)
    {
        if(r > n) return 0;
        long[] dp = new long[n + 1];
        dp[0] =1;
        for (int i = 1; i <= n; i++)
            dp[i] = i * dp[i - 1];
        return (int)((dp[n] / (dp[r] * dp[n - r])) % 1000000007);
    }
