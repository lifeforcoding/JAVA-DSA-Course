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
