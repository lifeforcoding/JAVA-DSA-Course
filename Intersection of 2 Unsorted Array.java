//Intersection of 2 sorted Array(Element Shouldn't repeat)
    public static int[] intersect2SortedArray(int[] nums1, int[] nums2) {
            int i = 0, j = 0;
            ArrayList<Integer> s = new ArrayList<>();
            while (i < nums1.length && j < nums2.length) {
                if (i > 0 && nums1[i] == nums1[i - 1]) {
                    i++;
                    continue;
                }
                if (nums1[i] == nums2[j]) {
                    s.add(nums1[i]);
                    i++;
                    j++;
                }
                else if (nums1[i] > nums2[j])
                    j++;
                else i++;
            }
            int[] ans = new int[s.size()];
            int m = 0;
            for (int e : s)
                ans[m++] = e;
            return ans;
    }
