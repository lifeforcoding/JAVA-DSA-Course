public int maxArea(int M[][], int n, int m) {
        int max = 0;
        int[] a = new int[m];
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    if (a[j] >= 1)
                        a[j]++;
                    else a[j] = 1;
                }
                else {
                    a[j] = 0;
                }
            }
            int currentArea = getMaxArea(a,a.length);
            max = Math.max(currentArea, max);
        }
        return max;
    }
    //Function to find largest rectangular area possible in a given histogram.
    public static int getMaxArea(int[] hist, long n)
    {
        //Calling function for find the index of all the previous small element for each element
        int[] previousSmallIndex = previousindex(hist);
        //Calling function for find the index of all the next small element for each element
        int[] nextSmallElement = nextSmall(hist);
        //Calculating the max area for each bar by (rightsmallindex - previoussmallIndex -1) x  current size of the bar
        int maxArea = 0;
        for (int i = 0; i < n; i ++) {
            int area = ((nextSmallElement[i] - previousSmallIndex[i]) - 1) * hist[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public static int[] previousindex(int[] hist) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[hist.length];
        for (int i = 0; i < hist.length; i++) {
            while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = -1;
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    public static int[] nextSmall(int[] hist) {
        int n = hist.length - 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[hist.length];
        for (int i = n; i >= 0; i --) {
            while (!stack.isEmpty() && hist[i] <= hist[stack.peek()])
                stack.pop();
            if (stack.isEmpty())
                ans[i] = hist.length;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
