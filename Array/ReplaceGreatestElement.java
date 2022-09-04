public class ReplaceGreatestElement {
    public static void main(String[] args) {
    }
    //Function for replacing every element in the array with the greatest element on the right side

    public static void replaceGreatestElement(int[] a) {   //7,8,9,12,6,8,2,4,3,7
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                a[i] = 0;
                break;
            }
            int greatest = i + 1;
            for (int j = greatest + 1; j < a.length; j++) {
                if (a[j] > a[greatest])
                    greatest = j;
            }
            a[i] = a[greatest];
        }
    }
}
