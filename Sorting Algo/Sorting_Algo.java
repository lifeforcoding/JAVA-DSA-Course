public static void swap(int[] a, int from, int to) {
        int temp = a[from];
        a[from] = a[to];
        a[to] = temp;
    }
    //Sorting Algorithms
    //Bubble sort
    public static void bubbleSort(int[] a) {
        //[4,2,5,3,1]
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j])
                    swap(a, i , j);
            }
        }
    }

    //Insertion sort
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(temp < a[j])
                    a[j + 1] = a[j];
                else break;
            }
            a[j + 1] = temp;
        }
    }

    //Selection sort
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            swap(a, min, i);
        }
    }
