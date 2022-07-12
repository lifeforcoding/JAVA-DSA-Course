//Function for quick sort Algo
    public static void quickSort(int[] arr, int s, int e) {
        //Base case
        if (s >= e)
            return;
        //Make the partition and place the pivot in their correct place
        int pivot = partition(arr, s, e);
        //Sort the lest side of the pivot
        quickSort(arr, s, pivot - 1);
        //Sort the right side of the pivot
        quickSort(arr, pivot + 1, e);
    }

    //Partition Function
    public static int partition(int[] arr, int s, int e) {
        int count = s; // To store the pivot index
        for (int i = s + 1; i <= e; i++) {
            if (arr[i] < arr[s])
                count++;
        }
        swap(arr, s, count);
        int k = count + 1; // Starting index after pivot point
        int m = s; //Starting index before the pivot point
        //Swapping element greater than the pivot to the left side
        while (m < count && k <= e) {
            if (arr[m] > arr[count]) {
                if (arr[k] < arr[count])
                    swap(arr, m++, k++);
                else {
                    k++;
                }
            }
            else m++;
        }

        return count;
    }

    //Swapping function
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
