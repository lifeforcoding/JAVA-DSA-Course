public static int longestCommonSubsequence(String text1, String text2) {
        return helper(text1, text2, text1.length() -1, text2.length() - 1);
    }
public static int helper(String text1, String text2, int i, int j) {
        if (i < 0 || j < 0) return 0;

        if (text1.charAt(i) == text2.charAt(j))
            return helper(text1, text2, i -1, j-1) + 1;
        else {
            return Math.max(helper(text1, text2, i-1, j), helper(text1, text2, i, j-1));
        }
    }
