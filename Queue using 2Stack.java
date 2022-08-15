class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> temp;
    public MyQueue() {
        stack = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        while (!stack.empty())
            temp.push(stack.pop());
        int ans = temp.pop();
        while (!temp.empty())
            stack.push(temp.pop());
        return ans;
    }

    public int peek() {
        while (!stack.empty())
            temp.push(stack.pop());
        int ans = temp.peek();
        while (!temp.empty())
            stack.push(temp.pop());
        return ans;
    }

    public boolean empty() {
        return stack.empty();
    }
}
