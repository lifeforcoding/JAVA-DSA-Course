static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0; // Defining the arrival and departure array pointer
        int max = 0; // This place will hold the maximum no platform required of all the times
        int current = 0; // this place will hold the no of platform required currently

        while (i < n && j < n) {
            if (arr[i] <= dep[i]) {
                current++;
                i++;
                max = Math.max(current, max);
            }
            else {
                current--;
                j++;
            }
        }
        return max;
    }
