int maxLen(int arr[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int cumSum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            cumSum += arr[i];
            if(cumSum == 0) maxLength = i +1;
            if (map.containsKey(cumSum))
                maxLength = Math.max(maxLength, i +1- map.get(cumSum));
            else map.put(cumSum, i+1);
        }
        return maxLength;
    }
