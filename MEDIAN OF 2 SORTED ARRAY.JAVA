public static double medianOf2SortedArray(int[] a, int[] b) {
        //Condition if 'a' is not smaller than array 'b'
        if (a.length > b.length)
            return medianOf2SortedArray(b,a);
        //Length of both the array
        int n1 = a.length;
        int n2 = b.length;

        //Calculating the cut point for both array
        int low = 0, high = n1; //Go by considering the length of the small array
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = ((n1 + n2 + 1) / 2) - cut1; // We add 1 to because this will work for both the even and odd numbers of merged array

            //Calculating the rightmost value of left cut and leftmost value of the right cut for both the array
            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];

            int right1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
            int right2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];

            //Check if the partitions are valid made by the cuts
            if (left1 <= right2 && left2 <= right1) {
                //If the merge length of both the array is even
                if ((n1 + n2) % 2 == 0)
                    return (Math.max(left1,left2) + Math.min(right1,right2)) / 2.0;
                //If length is odd
                else return Math.max(left1,left2);
            }
            //If left most right element is greater
            if (left1 > right2)
                high = cut1 - 1;
            //If right most left element is smaller
            else low = cut1 + 1;
        }
        return 0.0;
    }
