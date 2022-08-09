public static String reverseTheWord(String S) {
        char[] charArray = S.toCharArray();
        int startIndex = 0;
        int endIndex = S.indexOf('.', startIndex);
        while (endIndex >=0) {
            reverseLetters(charArray, startIndex, endIndex);
            startIndex = endIndex + 1;
            endIndex = S.indexOf('.', startIndex);
        }
        reverseLetters(charArray, S.lastIndexOf('.') + 1, charArray.length);
        reverseLetters(charArray, 0, charArray.length);
        return new String(charArray);
    }
    public static void reverseLetters(char[] ch, int start, int end) {
        for (int i = start; i < end; i++) {
            char temp = ch[i];
            ch[i] = ch[end - 1];
            ch[end - 1] = temp;
            end--;
        }
    }

// Using Stack
public String reverseWords(String s) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String ans = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                if (s.indexOf(" ",i) < 0) {
                    stack.push(s.substring(i));
                    i = s.length();
                }
                else {
                    stack.push(s.substring(i, s.indexOf(" ", i)));
                    i = s.indexOf(" ", i);
                }
                continue;
            }
            i++;
        }
        while (!stack.isEmpty()) {
            ans += stack.pop() + " ";
        }
        
        return ans.substring(0,ans.length() - 1);
    }
