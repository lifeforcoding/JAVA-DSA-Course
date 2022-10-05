//Minimum operation to perform to convert string s1 into s2 if deletion, insertion and replace is allowed
public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Integer[][] dp = new Integer[n][m];
        return helper(word1, word2, dp, n - 1, m - 1);
    }
    public static int helper(String word1, String word2, Integer[][]dp, int n, int m) {
        if (n < 0) return m + 1;
        if (m < 0) return n + 1;
        if (dp[n][m] != null) return dp[n][m];

        if (word1.charAt(n) == word2.charAt(m)) {
            dp[n][m] = helper(word1, word2, dp, n - 1, m - 1);
        }
        else {
          //The 1st recursive call is for insertion(by hypothetically inserting a element is the word 1 end,
          //The second recursive call is for deletion 
          //The 3rd recursive call is for replacement
            dp[n][m] = 1 + Math.min(helper(word1, word2, dp, n, m - 1),
                       Math.min(helper(word1, word2, dp, n - 1, m), 
                               helper(word1, word2, dp, n - 1, m - 1)));
        }
        return dp[n][m];
    }


//recursive stack Space Optimised Tebular Mathod
public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i -1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
