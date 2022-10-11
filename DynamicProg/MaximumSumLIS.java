public static int maxSumIS(int[] arr, int n) {
        //This array represents maximum sum of subsequences for each individual index
        //i.e:- max_Sum[5] represent all its previous maximum increasing subsequence sum plus this value of arr[5]
        int[] max_Sum = new int[n];
        //At the current time the max sum array will consist the value of itself as maximum sum
        System.arraycopy(arr, 0, max_Sum, 0, n);
        int maxValue = arr[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //The condition will be whenever we find an index with greater number in the original array then the j index 
                // then at that time we take the max_Sum value of that particular index and add it to the value of the current arr index and update the 
                // i index of the max sum array if the sum is larger than the value already presented here.
                if (arr[j] < arr[i]) {
                    max_Sum[i] = Math.max(max_Sum[j] + arr[i], max_Sum[i]);
                    maxValue = Math.max(max_Sum[i], maxValue); // On each update it will keep track of the max value of the array 
                }
            }
        }
        return maxValue;
    }
