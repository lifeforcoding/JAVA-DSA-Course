public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n + 1];
        return count(nums, n, dp, 0, -1);
    }
    //Function to calculate the length of LIS
    public static int count(int[] nums, int n, Integer[][] dp, int index, int prev_index) {
        if(index == n) return 0;
        if (dp[index][prev_index + 1] != null) return dp[index][prev_index + 1];

        //Condition for not taking the current index element into the LIS
        int length_notTaken = count(nums, n, dp, index + 1, prev_index);
        int length_Taken = 0;
        //Condition for taking the current index element into the LIS
        if (prev_index == -1 || nums[index] > nums[prev_index])
            length_Taken = 1 + count(nums, n, dp, index + 1, index);
        return dp[index][prev_index + 1] = Math.max(length_notTaken, length_Taken);
    }




// Find the length of the Lis using Binary Search
public int lengthOfLIS(int[] nums) {
         int n = nums.length;
        int[] temp = new int[n];
        temp[0] = nums[0];
        int length = 1;
        for (int i = 1; i < n; i++) {
            //If the current element is greater then the last element in the temp array then we simply insert it 
            // in the temp array, otherwise we have to find out the insertion point by using binary search and insert at that position
            if (nums[i] > temp[length - 1]) {
                temp[length] = nums[i];
                length++;
            }
            else {
                int replaceIndex = binarySearch(temp, nums[i], length);
                temp[replaceIndex] = nums[i];
            }
        }
        return length;
    }
    public static int binarySearch(int[] temp, int key, int n) {
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == temp[mid])
                return mid;
            else if (key < temp[mid])
                high = mid - 1;
            else low = mid + 1;
        }
        //If the key is greater then the temp[mid] we have to return mid + 1 as the insertion point
       if (key > temp[mid])
            return mid + 1;
        else return mid;
    }
