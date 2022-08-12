class GfG
{
    int minEle;
    Stack<Integer> s;
    public GfG() { s = new Stack<Integer>(); }
    /*returns min element from stack*/
    int getMin()
    {
        if (!s.isEmpty())
	return minEle;
	return -1;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if (!s.isEmpty()) {
	if (s.peek() < minEle) {
            int t = minEle;
            minEle = 2 * minEle - s.pop();
            return t;
        }
        else return s.pop();	
        }
        return -1;
    }

    /*push element x into the stack*/
    void push(int x)
    {
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
