public static int palindromePartitioning(String str) {
        int n = str.length();
        Integer[] dp = new Integer[n];
        return partitionHelper(0, n, str, dp) - 1;
    }
    public static int partitionHelper(int index, int last, String str, Integer[] dp) {
        if (index == last) return 0;

        if (dp[index] != null) return dp[index];
        int minPartition = Integer.MAX_VALUE;

        for (int i = index; i < last; i++) {
            int count = 0;
            //For every iteration we check if we make partition in the current index then is it a became a palindrome if so we put 1 in count and calling a recursive
          // Function by adding into it
            if (isPalindrome(index, i, str)) {
                count = 1 + partitionHelper(i + 1, last, str, dp);
                minPartition = Math.min(count, minPartition); // After find out the total no of partition we compare it with already derrived partition and store it
            }
        }
        return dp[index] = minPartition;
    }

    public static boolean isPalindrome(int start, int end, String str) {
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--))
                return false;
        }
        return true;
    }
