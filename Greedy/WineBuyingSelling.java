 int wineSelling(int A[],int N){
        //Taking 2 pointer for storing current buyer index and seller index 
        int currentBuyer = 0, currentSeller = 0;
        int ans = 0;
        while (currentBuyer < N && currentSeller < N) {
            //loop to find the buyer using it's property
            while (A[currentBuyer] <= 0) {
                currentBuyer++;
                if (currentBuyer == N) return ans;
            }
            //loop to find the seller using it's property
            while (A[currentSeller] >= 0) {
                currentSeller++;
                if (currentSeller == N) return ans;
            }
            //Condition when buyer quantity exceeds then the seller quantity
            if (Math.abs(A[currentBuyer]) >= Math.abs(A[currentSeller])) {
                ans += Math.abs(currentBuyer - currentSeller) * Math.abs(A[currentSeller]);
                A[currentBuyer] += A[currentSeller];
                A[currentSeller] = 0;
            }
            //Condition when seller quantity exceeds then the buyer quantity
            else {
                ans += Math.abs(currentBuyer - currentSeller) * A[currentBuyer];
                A[currentSeller] += A[currentBuyer];
                A[currentBuyer] = 0;
            }
        }
        return ans;
    }
