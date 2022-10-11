public int eraseOverlapIntervals(int[][] intervals) {
        //Here the logic is sort the 2D array on the norther coordinate basis because when we sort the north then we apply
        //LIS to the southern coordinates so the north will increase because it is sorted and the southern will also increasing because we
        //are finding LIS of the southern coordinates
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
        int n = intervals.length;
        int[] dp = new int[n];
        int nonOverLap = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (intervals[i][1] > intervals[j][1]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            nonOverLap = Math.max(nonOverLap, dp[i]);
        }
        return n - nonOverLap;
    }
