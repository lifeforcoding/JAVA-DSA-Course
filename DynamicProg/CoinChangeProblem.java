public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Integer[] dp = new Integer[amount];
        return coinDP(coins, amount, dp);
    }
    public static int coinDP(int[] coins, int amount, Integer[] dp) {
        if (amount == 0) return 0; 
        if (amount < 0) return -1;
        //DP array to check if it is already computed
        if (dp[amount - 1] != null) return dp[amount - 1];
        //Initialize the minimum with integer max so that we can compare with the lesser denomination if found
        int min = Integer.MAX_VALUE;
        //Loo to check the remaining amount with the possible denomination
        for (int e : coins) {
            int res = coinDP(coins, amount - e, dp); // Store the no of coins required if we go with the 'e' denomination
            //If the 'res' no of coin required, found is lesser than the current min we update the min with min + 1
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        //If all the denomination are not possible for further change in that case the min will not update and at that point we assign the dp array with -1
        //Otherwise we update dp with min.
        return dp[amount - 1] = ((min == Integer.MAX_VALUE)? -1 : min);
    }
