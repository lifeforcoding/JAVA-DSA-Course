//Reverse stack using recursion
static void reverse(Stack<Integer> s)
    {
        if (s.isEmpty())
            return;
        int top = s.pop();
        reverse(s);
        insertAtBottom(top, s);
    }
    public static void insertAtBottom(int element, Stack<Integer> stack) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertAtBottom(element, stack);
        stack.push(top);
    }

