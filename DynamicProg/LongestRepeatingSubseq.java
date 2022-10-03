public int LongestRepeatingSubsequence(String text1) {
        int n = text1.length();
        int[][] dp = new int[2][n + 1];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            index = i & 1; //On every iteration of the outer loop, it will point the current row as the previous row
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i -1) == text1.charAt(j -1) && i != j)
                    dp[index][j] = dp[1 - index][j - 1] + 1;
                else dp[index][j] = Math.max(dp[1 - index][j], dp[index][j - 1]);
            }
        }
        return dp[index][n];
    }
