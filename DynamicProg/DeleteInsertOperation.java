//Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.
public static int longestCommonSubsequence(String text1, String text2) {
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
        int highLength = Math.max(m, n);
        return (highLength - dp[index][n] + ((highLength == m)? n - dp[index][n] : m - dp[index][n]));
    }
