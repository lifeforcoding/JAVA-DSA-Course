//Basic Set and Map Problems
    //Count Distinct element in an array
    public static int countDistinct(int[] a) {
        Set<Integer> dist = new HashSet<>();
        for (int e : a) {
            dist.add(e);
        }
        return dist.size();
    }

    //Frequency of element in an array
    public static void frequencyOfElement(int[] a) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int e : a) {
            if (!freq.containsKey(e))
                freq.put(e, 1);
            else {
                int value= freq.get(e);
                value++;
                freq.put(e, value);
            }
        }
        System.out.println(freq);
    }

    //Pair with given sum in an unsorted array


    public static pair givenSumPair(int[] a, int sum) {
        Set<Integer> s1 = new HashSet<>();
        for (int e : a) {
            int compSum = sum - e;
            if (s1.contains(compSum))
                return new pair(e, compSum);
            s1.add(e);
        }
        return null;
    }
}
class pair {
    int a, b;

    public pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
//Check if the array has sub array of 0 sum
    public static boolean subArrayZero(int[] a) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int cs = 0;
        for (int e : a) {
            cs += e;
            if (set.contains(cs))
                return true;
            set.add(cs);
        }
        return false;
    }
