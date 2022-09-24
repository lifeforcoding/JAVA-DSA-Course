//Find the maximum sum of absolution difference of any permutation of a given array
    public static int maxSum(int[] arr, int n) {
        Arrays.sort(arr);
        int i = 0, j = n -1; //pointer to holds the smaller element and larger element index from that array
        int ans = 0;
        boolean flag = true; //This flag will determine if we increment the smaller element index or decrement the larger element index
        while (i < j) {
            ans += Math.abs(arr[i] - arr[j]);
            if (flag)
                i++;
            else j--;
            flag = !flag;
        }
        ans += Math.abs(arr[0] - arr[n /2]);//Handle the difference between the 1st and mid element which is not incurred in the loop
        return ans;
    }
