public class MaximumSumOfSubArray {
    public static void main(String[] args) {

    }
    public static int maximumSumOfSubArray(int[] a) {   //7,8,9,12,6,8,2,4,3,7
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int l = -1, r = -1;
        for (int i = 0; i < a.length; i++) {
            currentSum += a[i];
            if (currentSum < 0) {
                currentSum = 0;
                l = i + 1;
                r = -1;
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                r = i;
            }
        }
        while (l <= r) {
            System.out.print(a[l] + " ");
            l++;
        }
        return maxSum;
    }
}
