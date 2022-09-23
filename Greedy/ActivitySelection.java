class Pair implements Comparable<Pair>{
    int s;
    int e;
    public Pair(int s, int e) {
        this.s = s;
        this.e = e;
    }
    public int getS() {
        return s;
    }
    public int getE() {
        return e;
    }
    @Override
    public int compareTo(Pair o) {
        return this.e - o.getE();
    }
}

public static int activitySelection(int start[], int end[], int n)
    {
        Pair[] pair = new Pair[n];
        //Creating the pair of start and end point and store it in a array
        for (int i = 0; i < n; i++)
            pair[i] = new Pair(start[i],end[i]);
        Arrays.sort(pair);

        int count = 1;
        int currentEnd = pair[0].getE();
        for (int i = 1; i < n; i++) {
            if (pair[i].getS() > currentEnd) {
                count++;
                currentEnd = pair[i].getE();
            }
        }
        return count;
    }
