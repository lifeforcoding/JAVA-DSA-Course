public static char findKthBitValue(long n, long k) {
        if ((n & (1 << k)) != 0)
            return '1';
        else return '0';
    }
    
    //Toggle the i-th bit
    public static int toggleTheIthBit(int n, int i) {
        int mask = 1 << (i - 1);
        return n^mask;
    }

    //Check if a number is power of 2
    public static boolean isPowerOfTwo(int n) {
        return ((n & n - 1) == 0);
    }

    //Count the number of set bits in a number
    public static int countNoOfSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n >>= 1;
        }
        return count;
    }

    //Check is a number is odd or even using bit manipulation.
    public static String isOddEven(int n) {
        if ((n & 1) == 1)
            return "odd";
        else return "even";
    }

    //Swap two numbers without using a third variable
    public static void swapWithoutTemp(int x, int y){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x is " + x + " y is " + y);
    }

    //set the i-th bit to 1
    public static int setTheIthBit(int n, int i) {
        int a = (n | (1 << i));
        return a;
    }

    //Given a number N the task is to find the XOR of all numbers from 1 to N.
    public static int xorOfNumbersUpto(int n) {
        int ans = 0;
        int i = 1;
        while (i <= n) {
            ans ^= i;
            i++;
        }
        return ans;
    }

    //calculate Number of bit to be flipped to convert one number to another.
    public static int flippedBitsToChangeNumber(int from, int to) {
        int xor = from ^ to;
        int count = 0;
        while (xor > 0) {
            if ((xor & 1) == 1)
                count++;
            xor >>= 1;
        }
        return count;
    }
