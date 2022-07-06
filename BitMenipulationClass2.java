//Find the total number of set bit Optimised
public static int findTotalSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n -1);
            count++;
        }
        return count;
    }

    //find the only non repeating element in the array where every other element repeat twice.
    public static int findOnlyRepeatingElement(int[] a) {
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans ^= a[i];
        }
        return ans;
    }

    //find the two non repeating element in the array where every other element repeat twice.
    public static int[] findTwoRepeatingElement(int[] a) {
        int xor = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
        }
        int firstNumber = xor;
        int secondNumber = 0;
        int mask = xor & (~(xor - 1));
        for (int e : a) {
            if ((mask & e) == 0)
                firstNumber ^= e;
        }
        secondNumber = xor ^ firstNumber;
        return new int[]{firstNumber, secondNumber};
    }

// Swap 2 bit in a given integer
    public static int swapTwoBit(int n, int i, int j) {
        if (((n >> i) & 1) == ((n >> j) & 1))
            return n;
        int mask = (1 << i) | (1 << j);
        int ans = n ^ mask;
        return ans;
    }

    //Reverse the bits of a 32bit unsigned integer
    public static int reverseTheBits(int a) {
        int ans = 0;
        int i = 0;
        while (i < 31) {
            if (((a >> i) & 1) != 0)
                ans += (1 << (31 - i));
            i++;
        }
        return  ans;
    }
