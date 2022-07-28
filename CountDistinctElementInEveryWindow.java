//Count the distinct element in every window of size k
    public static ArrayList<Integer> countDistinct(ArrayList<Integer> a, int k) {
        ArrayList<Integer> ans = new ArrayList<>(); // To store the answer of each window
        Map<Integer, Integer> map = new HashMap<>();
        //Check in the 1st k length window
        for (int i = 0; i < k; i++)
            map.put(a.get(i),map.getOrDefault(a.get(i),0) + 1);
        ans.add(map.size()); // Adding the result to ans.

        //Checking for remaining window.
        for (int i = 0, j = k; j < a.size();) {
            //Releasing the 1st element of the window
            int value = map.get(a.get(i));
            if (value == 1)
                map.remove(a.get(i));
            else map.put(a.get(i), value - 1);
            //Acquiring the next element of the windows
            map.put(a.get(j),map.getOrDefault(a.get(j), 0) + 1);
            ans.add(map.size());
            i++;
            j++;
        }
        return ans;
    }
