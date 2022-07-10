//Find minimum difference between any 2 pairs in an array
    public static int minDiff(int[] a) {
        Arrays.sort(a);
        int ans  = Integer.MAX_VALUE;
        int l = 0;
        int r = 1;
        while (r < a.length) {
            ans = Math.min(ans, (a[r] - a[l]));
            l++;
            r++;
        }
        return ans;
    }
