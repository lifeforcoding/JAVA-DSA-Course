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
        //This loop will fill the 2d array such that if there is n no of element available in s1/s2 and 0 no. of element remaining
        //in the string s2/s1 then what should be the dp array should return
        for(int i = 0; i <= n; i++)
            dp[0][i] = i;
        for (int j = 0; j <= m; j++)
            dp[j][0] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i -1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }


//Space Optimised further using a array of only 2 rows only and columns are as per string 2.length +1
public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[2][m+1];
        int index = 0;
        //This loop will fill the 2d array such that if there is n no of element available in s1/s2 and 0 no. of element remaining
        //in the string s2/s1 then what should be the dp array should return
        for(int i = 0; i <= m; i++)
            dp[index][i] = i;

        for (int i = 1; i <= n; i++) {
            index = i & 1; //Alternate the index between 0 & 1
            dp[index][0] = i;
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[index][j] = dp[1 - index][j - 1];
                else {
                    dp[index][j] = 1 + Math.min(dp[1 - index][j - 1], Math.min(dp[1 - index][j], dp[index][j - 1]));
                }
            }
        }
        return dp[index][m];
    }
