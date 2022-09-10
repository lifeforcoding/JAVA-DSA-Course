public boolean countSub(long arr[], long n) {
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if ((2 * i) + 1 < n)
                if (arr[(2 * i) + 1] > arr[i]) return false;
            if ((2 * i) + 2 < n)
                if (arr[(2 * i) + 2] > arr[i]) return false;
        }
        return true;
    }
