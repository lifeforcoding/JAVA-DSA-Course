public int LongestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];// Holds LIS starting from index 0 to n-1
        int[] dp2 = new int[n];// Holds LIS starting from index n -1 to 0

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);

        //Calculate LIS of the given order
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp1[i] = Math.max(dp1[i], 1 + dp1[j]);
            }
        }

        //Calculate LIS of the array in reverse order
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j])
                    dp2[i] = Math.max(dp2[i], 1 + dp2[j]);
            }
        }

        int longest = 0; // Holds the Longest Bitonic Subsequences length
        for (int i = 0; i < n; i++)
            longest = Math.max(longest, (dp1[i] + dp2[i]) - 1);
        return longest;
    }
