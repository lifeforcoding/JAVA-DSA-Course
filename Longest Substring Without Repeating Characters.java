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
