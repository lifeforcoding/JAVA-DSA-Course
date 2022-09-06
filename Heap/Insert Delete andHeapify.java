class Heap {
    int[] arr = new int[100];
    int size;
    public Heap() {
        arr[0] = -1;
        size = 0;
    }
    //Function for add an element in a max heap
    public void insert(int val) {
        size++;
        int index = size;
        arr[index] = val;
        while (index > 1) {
            int parent = index / 2;
            if (arr[parent] < arr[index]) {
                swap(arr, parent, index);
                index = parent;
            }
            else return;
        }
    }

    //Function for deletion of the root node in a heap
    public void delete() {
        arr[1] = arr[size]; //Replace the root node with the last node of the heap.
        size--; // Decrement the size of the heap.
        //Propagate the new root node to it's correct place
        int i = 1;
        while (i < size) {
            int leftIndex = 2 * i;
            int rightIndex = (2 * i) + 1;

            if (leftIndex < size && arr[i] < arr[leftIndex]) {
                swap(arr, i, leftIndex);
                i = leftIndex;
            }

            else if (rightIndex < size && arr[i] < arr[rightIndex]) {
                swap(arr, i, rightIndex);
                i = rightIndex;
            }
            else return;
        }
    }

    //Heapify algorithm(convert the current given node subtree into a heap)
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
    public static void swap(int[] arr, int parent, int index) {
        int temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }
