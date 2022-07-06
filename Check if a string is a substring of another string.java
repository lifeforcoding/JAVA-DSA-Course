ublic static void printMatchingIndex(String m, String n) {
        int s1 = m.length();
        int s2 = n.length();
        //Loo[ to run till s2 - s1 otherwise it will be out of bound
        for (int i = 0; i <= (s2 - s1); i++ ) {  
            int j = 0;
            for (; j < s1; j++) {
                if (n.charAt(i + j) != m.charAt(j)) //Here is i + j because the index if i also increases here without changing the i
                    break;
            }
            if (j == 3) 
                System.out.println("The match is found at index" + i);
        }
    }
