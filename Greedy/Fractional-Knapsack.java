double fractionalKnapsack(int W, Item arr[], int n) 
    {
//Sort the custom item array by passing lambda comparator  
       Arrays.sort(arr, (o1, o2) -> (o1.weight * o2.value - o2.weight * o1.value));
        int i = 0;
        double value = 0;
        while (W > 0 && i < n) {
            if (W >= arr[i].weight) {
                W -= arr[i].weight;
                value += arr[i].value;
            }
            else {
                value += (double) ((arr[i].value * W) / (double)(arr[i].weight));
                W = 0;
            }
            i++;
        }
        return value;
    }
