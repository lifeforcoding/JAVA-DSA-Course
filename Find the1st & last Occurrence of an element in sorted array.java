public static int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = indexOf1stOccur(nums, target);
        ans[1] = indexOfLastOccur(nums, target);
        return ans;
    }
    //Index of 1st occurrence of an element in an sorted array.
    public static int indexOf1stOccur(int[] a, int key) {
        int s = 0; int e = a.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == key) {
                ans = mid;
                e = mid - 1;
            }
            else if (key > a[mid])
                s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
    //Index of last occurrence of an element in a sorted array.
    public static int indexOfLastOccur(int[] a, int key) {
        int s = 0; int e = a.length - 1;
        int ans = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == key) {
                ans = mid;
                s = mid + 1;
            }
            else if (key > a[mid])
                s = mid + 1;
            else e = mid - 1;
        }
        return ans;
    }
