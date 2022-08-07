public static long[] nextLargerElement(long[] arr, int n) {
        ArrayDeque<Long> stack = new ArrayDeque<>();
        long[] ans = new long[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = -1;
                stack.push(arr[i]);
            }
            else {
                if (arr[i] < stack.peek()) {
                    ans[i] = stack.peek();
                    stack.push(arr[i]);
                }
            }
        }
        return ans;
    }
