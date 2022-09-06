public class Solution
{
	public static int[] buildMinHeap(int[] arr)
	{
	    int n = arr.length;
        for (int i = n / 2 -1; i >=0 ;i--) {
            heapify(arr, n, i);
        }
        return arr;
	}
    public static void heapify(int[] arr, int size, int i) {
        int smallest = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = (2 * i) + 2;

        if (leftIndex < size && arr[smallest] > arr[leftIndex])
            smallest = leftIndex;
        if (rightIndex < size && arr[smallest] > arr[rightIndex])
            smallest = rightIndex;

        if (smallest != i) {
            swap(arr, smallest, i);
            heapify(arr, size, smallest);
        }
    }
    public static void swap(int[] arr, int parent, int index) {
        int temp = arr[parent];
        arr[parent] = arr[index];
        arr[index] = temp;
    }
}
