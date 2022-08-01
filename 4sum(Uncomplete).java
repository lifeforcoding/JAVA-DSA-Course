public static void fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return ;
        Map<Integer, pair> map = new HashMap<>();
        int n = nums.length;
        //Put all the 2 sum for all element in the array in the map
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++)
                map.put(nums[i] + nums[j], new pair(i, j));
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int firstSum = nums[i] + nums[j];
                int secondSum = target - firstSum;

                if (map.containsKey(secondSum)){
                    if (firstSum == -5)
                        System.out.println(nums[i] + " "+ nums[j] + " " + secondSum);
                    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[map.get(secondSum).i],nums[map.get(secondSum).j]));
                    Collections.sort(list);
                    pair p = map.get(secondSum);
                    if (firstSum == -5)
                        System.out.println(nums[p.i] + " " + nums[p.j]);
                    if (!ans.contains(list) && p.i != i && p.j != i && p.i != j && p.j != j)
                        ans.add(list);
                }
            }
        }
        //return ans;
    }
}
class pair {
    int i, j;
    public pair(int i, int j) {
        this. i = i;
        this.j = j;
    }
