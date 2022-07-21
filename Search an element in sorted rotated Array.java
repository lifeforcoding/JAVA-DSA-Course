//Search an element in a sorted rotated array
    public static int searchInRotated(int[] a, int key) {
        int l = 0;
        int r = a.length - 1;
        while(l <= r) {
            int mid = l + (r - l)/2;
            if(a[mid] == key) return mid;
            if(a[l] <= a[mid]) { // left part sorted
                if(key >= a[l] && key < a[mid]) { // left side present
                    r = mid-1;
                } else { // right side present
                    l = mid+1;
                }
            } else { // right part sorted
                if(key > a[mid] && key <= a[r]) { // right side present
                    l = mid+1;
                } else { // left side present
                    r = mid-1;
                }
            }
        }
        return -1;
    }
