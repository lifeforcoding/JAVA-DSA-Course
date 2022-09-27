//Find Maximum Equal sum of Three Stacks
public static int maxEqualSum(int N1,int N2,int N3, int[] S1, int[] S2, int[] S3) {
            int t1 = 0, t2 = 0, t3 = 0;
            for (int e : S1) t1 += e;
            for (int e : S2) t2 += e;
            for (int e : S3) t3 += e;
            int i = 0, j = 0,  k = 0;
            while (true) {
                if (i == N1 || j == N2 || k == N3)
                    return 0;
                if (t1 == t2 && t2 == t3)
                    return t1;
                int maxSumArr = map.get(Math.max(Math.max(t1, t2), t3));
                if (t1 >= t2 && t1 >= t3)
                    t1 -= S1[i++];
                else if (t2 >= t1 && t2 >= t3)
                    t2 -= S2[j++];
                else if (t3 >= t2 && t3 >= t1)
                    t3 -= S3[k++];
            }
    }
