//Check if a given number n is a ugly number or not
public boolean isUgly(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        while (n != 1) {
            if ((n % 2) == 0) n = n / 2;
            else if ((n % 3) == 0) n /= 3;
            else if ((n % 5) == 0) n /= 5;
            else return false;
        }
        return true;
    }
