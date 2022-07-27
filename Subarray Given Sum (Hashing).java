//Subarray with given sum using hashing
    public static void subArrayGivenSum(int[] a, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        int cs = 0; //Cumulative sum
        int start = 0;
        int end = 0;
        for (int i = 0; i < a.length; i++) {
            cs += a[i];
            if (cs == sum) {
                end = i;
                System.out.printf("The given sum subarray is starting from %d to %d", start, end);
                break;
            }
            else if (map.containsKey(cs - sum)) {
                start = map.get(cs - sum) + 1;
                end = i;
                System.out.printf("The given sum subarray is starting from %d to %d", start, end);
                break;
            }
            else map.put(cs,i);
        }
        System.out.println("No subarray is found for the given sum");
    }
