//Assign Mice holes
    static int assignMiceHoles(int N , int[] M , int[] H) {
        Arrays.sort(M);
        Arrays.sort(H);
        //The logic behind sorting is we will put the mice who is far away to it's nearest position which is also far away
        int ans = 0;
        for (int i = 0; i < N; i++)
            ans = Math.max(ans, Math.abs(M[i] - H[i]));
        return ans;
    }
