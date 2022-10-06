//Return the minimum no. of jumps required to reach the end of the index
public int jump(int[] nums) {
        int n = nums.length;
        int crr_step = 0;
        int last_MaxReach = 0;
        int crr_MaxReach = 0;

        for (int i = 0; i < n - 1; i++) {
            crr_MaxReach = Math.max(crr_MaxReach, i + nums[i]);
            //The logic behind this condition is by the time we traverse all the reachable index less than
            // or equal to the last_MaxReach we already had found the next crr_MaxReach index
            // so at that time we update the step count and update the Last max reach with the crr_MaxReach
            if (i == last_MaxReach) {
                crr_step++;
                last_MaxReach = crr_MaxReach;
            }
        }
        return crr_step;
    }
