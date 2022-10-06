//Return true if you can reach the last index, or false otherwise.
public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;

        //Indicates the max distance we can traver from the 'i' th position
        int maxDistance = 0;
        //Loop to check for max distance we can go from every index
        for (int i = 0; i < n; i++) {
            //If any time we are at the i th index and the max distance index still behind the ith index we return false
            if (i > maxDistance) return false;
            maxDistance = Math.max(maxDistance, i + nums[i]);
        }
        return true;
    }

