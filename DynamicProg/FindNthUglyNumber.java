public static void isUgly(int n) {
        int[] dp = new int[Math.abs(n) + 1];
        dp[0] = 1; //Initialise the dp array with 1st default ugly number '1'
        int c2 = 0,c3 = 0,c5 = 0; // Define the counter for all the 3 sequence of factor (2,3,5)
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.min(dp[c2] * 2,Math.min(dp[c3] * 3, dp[c5] * 5));
            if (dp[c2] * 2 == dp[i])
                c2++;
            if (dp[c3] * 3 == dp[i])
                c3++;
            if (dp[c5] * 5 == dp[i])
                c5++;
        }
        for (int e : dp)
            System.out.print(e + " ");
    }
