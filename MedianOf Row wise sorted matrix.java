public static int medianMatrix(int[][] matrix, int r, int c) {
        int low = 1,high = 2000;
        int desired = (r * c) / 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < r; i++) {
                count += checkLessElement(matrix[i], c, mid);
            }
            if (count <= desired) {
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return low;
    }

    //Check how much element is lesser than the mid
    public static int checkLessElement(int[] A, int col, int key) {
        int low = 0, high = col - 1;
        while (low <= high) {
            int mid = (low + high) /2 ;
            if (A[mid] <= key)
                low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
