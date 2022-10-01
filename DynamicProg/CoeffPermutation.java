//Calculation of permutation coefficient of P(n,k)
    public static int perCff(int n, int k) {
        int[] dp =new int[n + 1];
        dp[0] = 1;

        //Calculate the number of permutation of n element
        for (int i = 1; i <= n; i++) {
            dp[i] = i * dp[i - 1];
        }
        return dp[n] / dp[n - k];
    }
