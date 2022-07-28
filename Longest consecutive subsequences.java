Set<Integer> set = new HashSet<>();
        int longStreak = 0;
        //Put all the elements in the set
        for (int e : a)
            set.add(e);
        for (int e : a) {
            if (!set.contains(e - 1)) {
                int currentNum = e;
                int currentStreak = 1;
                while (set.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                longStreak = Math.max(longStreak, currentStreak);
            }
        }
        return longStreak;
