public static int lengthOfLastWord(String s) {
        int startIndex;
        int endIndex;
        if (s.length() == 0 || s.lastIndexOf(" ") < 0)
            return s.length();
        if (!((s.charAt(s.length() - 1) + "").equals(" "))) {
            startIndex = s.lastIndexOf(" ");
            endIndex = s.length() - 1;
        }
        else {
            endIndex = s.lastIndexOf(" ");
            while ((s.charAt(endIndex) + "").equals(" ")) {
                endIndex -= 1;
            }
            startIndex = s.lastIndexOf(" ", endIndex) + 1;
            endIndex++;
        }
        return s.substring(startIndex, endIndex).length();
        }
