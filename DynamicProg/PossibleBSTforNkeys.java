//Calculate Total number of possible Binary Search Trees with n keys
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        //We have to find the catalan number for given n which will the no of BST possible with the given nodes n
        //catalan number for any digit n f(3) = f(0) * f(2) + f(1) * f(1) * f(2) * f(0)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                dp[i] += dp[j - 1] * dp[i - j];
        }
        return dp[n];
    }
