//Given a rod of length N inches and an array of prices, price[]. pricei denotes the value of a piece of length i. 
//Determine the maximum value obtainable by cutting up the rod and selling the pieces.
public int cutRod(int price[], int n) {
        if (n == 0) return 0;
        Integer[] dp = new Integer[n];
        return rodCutDP(price, n, dp);
    }
    public static int rodCutDP(int[] price, int n, Integer[] dp) {
        if (n < 0) return Integer.MIN_VALUE;
        if (n == 0) return 0;
        if (dp[n - 1] != null) return dp[n - 1];

        int max = -1;
        for (int i = 0; i < price.length; i++)
            max = Math.max(max, price[i] + rodCutDP(price, n - i - 1, dp));
        return dp[n - 1] = max;
    }
