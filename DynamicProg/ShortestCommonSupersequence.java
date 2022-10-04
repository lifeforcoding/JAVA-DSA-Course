public String shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i -1) == text2.charAt(j -1))
                    dp[i][j] = dp[i -1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        //Here the logic is same as we do in printing the LCS but the difference is there we skip the index if the char at i and j
        //doesn't match but here we didn't ship that char and add append it into the string.
        StringBuilder ans = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans.append(text1.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(text1.charAt(i - 1));
                i--;
            }
            else {
                ans.append(text2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            ans.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            ans.append(text2.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
