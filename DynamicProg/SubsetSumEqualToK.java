//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum

public static boolean subsetSumToK(int n, int k, int arr[]){
        Integer[][] dp = new Integer[n][k + 1];
        return helper(arr, n - 1, k, dp);
    }
    public static boolean helper(int[] arr, int index, int target, Integer[][] dp) {
        if (target == 0) return true;
        if (index == 0) return arr[index] == target;

        if (dp[index][target] != null) return dp[index][target] == 1;
        // Call when not considering the current index element that's the reason why target is not updated 
        boolean notTaken = helper(arr, index- 1, target, dp);
        boolean taken = false;
        if (arr[index] <= target)
            // Call when considering the current index element that's the reason why target is updated by deduction from the current index element  
            taken = helper(arr, index - 1, target - arr[index], dp);
        dp[index][target] = notTaken || taken ? 1 : 0; // If any of the subsequences return true then fill the fp with 1
        return dp[index][target] == 1;
    }
