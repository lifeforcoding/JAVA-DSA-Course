//Here the logic is to cover 0 distance we have 1 way like that to cover 1 distance we have 1 way
    //To cover 2 distance we have 2 ways S we start a loop from 3. To find the answer for 3 distance we have to add all the ways
    // from 0 to n distance if we take 1 steps /2steps or 3 steps at a time
    static long countWays(int n) {
        long[] dp = new long[n + 1];
        if (n >= 0)
            dp[0] = 1;
        if (n >= 1)
            dp[1] = 1;
        if (n >= 2)
            dp[2] = 2; //These condition will define if there is 0,1 & 2 distance

        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3] ) % 1000000007;
        return (dp[n] % 1000000007);
    }
