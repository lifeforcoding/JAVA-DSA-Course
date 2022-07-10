//Union of 2 sorted array
    public static ArrayList<Integer> unionOfArray(int[] a, int[] b) {
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0;
        int j = 0;
        while (l < a.length || j < b.length) {
            if (l == a.length) {
                if (!ans.contains(b[j]))
                    ans.add(b[j]);
                j++;
                continue;
            }
            else if (j == b.length) {
                if (!ans.contains(a[l]))
                    ans.add(a[l]);
                l++;
                continue;
            }
            if (a[l] > b[j]) {
                if (!ans.contains(b[j]))
                    ans.add(b[j]);
                j++;
            }
            else if (a[l] < b[j]) {
                if (!ans.contains(a[l]))
                    ans.add(a[l]);
                l++;
            }
            else {
                if (!ans.contains(a[l]))
                    ans.add(a[l]);
                l++;
                j++;
            }
        }
        return ans;
    }
