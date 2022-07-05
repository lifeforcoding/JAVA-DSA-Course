//Find the left most character that repeats in a string
    public static char firstMostRepeatChar(String s) {
        int[] asciiChar = new int[256];
        for (int i = 0; i < s.length(); i++) {
            asciiChar[s.charAt(i)]++;
        }
        int index = -1;
        char ans = 0;
        int count = 0;
        for (int i = 0; i < asciiChar.length; i++) {
            if (asciiChar[i] > count) {
                ans = (char) i;
                index = s.indexOf(ans);
                count = asciiChar[i];
            }
          //Condition if same time occurence char found and the index is less then the previously found char
            else if (asciiChar[i] == count && s.indexOf((char) i) < index) {
                ans = (char) i;
                index = s.indexOf((char) i);
            }
        }
        return ans;
    }
