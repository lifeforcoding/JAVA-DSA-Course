public class Practice {
    public static void main(String[] args) {
        System.out.println(towerOfHanoi(2, 1,3,2));
    }
    public static long towerOfHanoi(int N, int from, int to, int aux) {
        if (N > 0){
            towerOfHanoi(N - 1, from, aux, to);
            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            towerOfHanoi(N - 1, aux, to, from);
        }
        return (long)(Math.pow(2, N) - 1);
    }
}
