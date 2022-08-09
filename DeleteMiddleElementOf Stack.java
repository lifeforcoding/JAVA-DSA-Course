//Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        int mid = (sizeOfStack + 1) / 2;
        delMid(s, mid, sizeOfStack);
    } 
    public static void delMid(Stack<Integer> s, int mid, int size) {
        if (size == mid) {
            s.pop();
            return;
        }
        int top = s.pop();
        delMid(s,mid,s.size());
        s.push(top);
    }
