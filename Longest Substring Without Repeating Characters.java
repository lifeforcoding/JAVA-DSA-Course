//Find the longest substring with distinct character.
    public static int checkDistinctCharString(String s) {
        String test = "";
        if (s.length() == 0)
            return 0;
        else if (s.length() == 1)
            return 1;
        int maxlength = -1;
        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);
            if (test.contains(current))
                test = test.substring(test.indexOf(current) + 1);
            test = test.concat(current);
            maxlength = (test.length() > maxlength? test.length() : maxlength);
        }
        return maxlength;
    }




//Longest substring without repeating character Using Hashmap
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        else if (s.length() == 1)
            return 1;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int currentStartIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            //Check if the current character present in the substring and if present then check if the index of it's presence
            //comes under the current substring window
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= currentStartIndex) {
                maxLength = Math.max(maxLength, i - currentStartIndex);
                currentStartIndex = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i),i);
        }
        maxLength = Math.max(maxLength, ((s.length()) - currentStartIndex));
        return maxLength;
    }
