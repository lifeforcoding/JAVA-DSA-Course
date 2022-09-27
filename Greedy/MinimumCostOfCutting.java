public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        int h = 1, v = 1; // Indicate the total number of boards that will affect if we cut vertically or horizontally
        int cost = 0; // Define the minimum cost of cutting
        Arrays.sort(X);
        Arrays.sort(Y);
        int i = M - 1;
        int j = N - 1;
        while (i >= 0 && j >= 0) {
            if (X[i] >= Y[j]) {
                v++;
                cost += X[i] * h;
                i--;
            }
            else {
                h++;
                cost += Y[j] * v;
                j--;
            }
        }
        //Condition, if after the loop any other cut is remaining in vertically or horizontally

        while (i >= 0) {
            cost += X[i] * h;
            i--;
        }
        while (j >= 0) {
            cost += Y[j] * v;
            j--;
        }
        return cost;
    }
