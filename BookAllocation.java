//Maximum pages of book allocate to a student that should be minimum
    public static int findPages(ArrayList<Integer> A,int N,int M) {
        if (A.size() < M)
            return -1;
        int maxPages = -1;
            int low = 0, high = 0;
            for (int e : A) {
                high += e;
                low = Math.max(low, e);
            }
            //Loop to check the maximum pages should be allocated to a student
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (isFeasible(A,mid,M)) {     //Condition to check if the pages in mid is distributed within M no of student
                    maxPages = mid;
                    high = mid - 1;
                }
                else low = mid + 1;
            }
            return maxPages;
    }

    //Function to check if the pages feasible to be the maximum pages
    public static boolean isFeasible(ArrayList<Integer> A, int mid, int n) {
        int pages = 0;
        int student = 0;
        for (int j : A) {
            pages += j;
            if (pages > mid) {
                pages = j;
                student++;
            }
        }
        return student <= n-1;
    }
