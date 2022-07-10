//Sorting an array of 0s,1s & 2s
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1)
                mid++;
            else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }
    public static void swap(int[] a,int from, int to) {
        int temp = a[from];
        a[from] = a[to];
        a[to] = temp;
    }

//Sort an array of 2 types element
    public static void sortElements(int[] a) {
        int low = 0, mid = 0;
        while (mid < a.length) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            }
            else if (a[mid] == 1)
                mid++;
        }
    }
