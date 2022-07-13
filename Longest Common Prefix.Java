//Find the longest common prefix in the array of strings using divide and conquer
    public static String longestCommonPrefix(String[] a,int s, int e) {
        //Base case
        if (s == e)
            return a[s];
        int mid = s + (e - s) / 2; // Midpoint to divide the array

        //Solve the 1st half of the array
        String s1= longestCommonPrefix(a,s, mid);
        //solve and return the answer from the 2nd part of the array
        String s2 = longestCommonPrefix(a,mid + 1, e);
        //Function to Merge the 2 answer to get their common prefix
        return checkCommonPrefix(s1, s2);
    }
    //Function to check and find the common prefix between the 2 string
    public static String checkCommonPrefix(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        String ans = "";
        for (int i = 0, j = 0; i < m && j < n; i++,j++) {
            if (s1.charAt(i) != s2.charAt(j))
                break;
            ans += s1.charAt(i);
        }
        return ans;
    }
