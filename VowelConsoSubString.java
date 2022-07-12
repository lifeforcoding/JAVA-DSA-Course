//Function to count substring starting with vowels and ending with consonants and vise versa
    public static int countSpecial(String A) {
        if (A.length() == 0 || A.length() == 1)
            return 0;
        //Variable of Total number of vowels and consonant
        int vow = 0, cons = 0;
        //Counting vowels and consonant.
        for (int i = 0; i < A.length(); i++) {
            if (isVowel(A.charAt(i)))
                vow++;
            else cons++;
        }
        //By taking the current char find the total number of
        //possible substring by adding the (available no. vowel after  it
        //if it is a consonant and decreasing the cons on each availability of consonant /
        //or Vise versa)
        int count = 0;
        for (int i = 0;i < A.length(); i++) {
            if (isVowel(A.charAt(i))) {
                vow--;
                count += cons;
            }
            else {
                cons--;
                count += vow;
            }
        }
        return count;
    }
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
