//find the longest chain which can be formed from the given set of pairs. 
int maxChainLength(Pair arr[], int n) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o.y)); //Lambdas for sorting a custom class array
        int rear = arr[0].y; // Holds the pointer to the y element of a pair in the max length pair chain
        int counter = 1; // Holds the max length of the max chain length at this point of i
        for (int i = 1; i < n; i++) {
            if (arr[i].x > rear) {
                counter++;
                rear = arr[i].y;
            }
        }
        return counter;
    }
