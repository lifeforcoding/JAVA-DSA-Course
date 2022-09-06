//Heapsort of maxheap in 1 based indexing
public static void heapify(int[] arr, int size, int i) {
            int largest = i;
            int leftIndex = 2 * i;
            int rightIndex = (2 * i) + 1;

            if (leftIndex < size && arr[largest] < arr[leftIndex])
                largest = leftIndex;
            if (rightIndex < size && arr[largest] < arr[rightIndex])
                largest = rightIndex;

            if (largest != i) {
                swap(arr, largest, i);
                heapify(arr, size, largest);
            }
        }

        //Heap sort algo
        public static void heapSort(int[] arr, int n) {
            int size = n;
            while (size > 1) {
                //Swap the root node with the last node of the array
                swap(arr, size, 1);
                size--; // Decrement the size of the heap array to unsorted part
                //Heapify the new root node
                heapify(arr, size, 1);
            }
        }
        public static void swap(int[] arr, int parent, int index) {
            int temp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = temp;
        }
