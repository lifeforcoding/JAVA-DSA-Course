class GfG
{
    int minEle;
    Stack<Integer> s = new Stack<>();

    /*returns min element from stack*/
    int getMin()
    {
        return minEle;
    }

    /*returns poped element from stack*/
    int pop()
    {
        if (s.pop() < minEle) {
            int t = minEle;
            minEle = 2 * minEle - t;
            return t;
        }
        else return s.pop();
    }

    /*push element x into the stack*/
    void push(int x) {
        if (s.isEmpty()) {
            minEle = x;
            s.push(x);
            return;
        }
        if (x < minEle) {
            s.push(2 * x - minEle);
            minEle = x;
        }
        else s.push(x);
    }
}
