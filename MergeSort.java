public static void main(String[] args) {
        int[] arr = new int[]{9,7,6,4,2,1,4};
        mergeSort(arr, 0, 6);
        for (int e: arr)
            System.out.print(e + " ");
    }
    //Function for Merge sort
    public static void mergeSort(int[] arr, int start, int end) {
        //Base case
        if (start >= end)
            return;
        int mid = (start + end) / 2; // Find the midpoint for partitioning

        //Sorting the left partition
        mergeSort(arr, start, mid);
        //Sorting the right partition
        mergeSort(arr, mid + 1, end);

        //Merging the 2 sorted partition
        merge(arr, start, end);
    }

    //Function for merging 2 Sorted array
    public static void merge(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        //Creating 2 separate array to store the sorted elements
        int[] a1 = new int[(mid - start) + 1];
        int[] a2 = new int[end - mid];

        //Copying the element to the 2 sorted array
        int mainarrayIndex = start;
        for (int i = 0; i < a1.length; i++)
            a1[i] = arr[mainarrayIndex++];
        mainarrayIndex = mid + 1;
        for (int i = 0; i < a2.length; i++)
            a2[i] = arr[mainarrayIndex++];

        //Merge  2 sorted array
        int index1 = 0;
        int index2 = 0;
        mainarrayIndex = start;
        while (index1 < a1.length && index2 <= a2.length) {
            if (a1[index1] < a2[index2])
                arr[mainarrayIndex++] = a1[index1++];
            else arr[mainarrayIndex++] = a2[index2++];
        }
        while (index1 < a1.length)
            arr[mainarrayIndex++] = a1[index1++];
        while (index2 < a2.length)
            arr[mainarrayIndex++] = a2[index2++];
    }
