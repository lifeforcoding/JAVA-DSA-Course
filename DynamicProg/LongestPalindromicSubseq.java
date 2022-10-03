public static int longestPalindromeSubseq(String text1) {
        StringBuilder s2 = new StringBuilder(text1);
        s2.reverse();
        String text2 = s2.toString();
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n + 1];
        int index = 0;
        for (int i = 1; i <= m; i++) {
            index = i & 1; //On every iteration of the outer loop, it will point the current row as the previous row
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i -1) == text2.charAt(j -1))
                    dp[index][j] = dp[1 - index][j - 1] + 1;
                else dp[index][j] = Math.max(dp[1 - index][j], dp[index][j - 1]);
            }
        }
        return dp[index][n];
    }
