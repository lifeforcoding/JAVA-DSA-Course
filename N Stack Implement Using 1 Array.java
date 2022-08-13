class NStack {
    // Initialize your data structure.
    int[] stack;
    int[] next;
    int[] top;
    int freeSpace;
    public NStack(int N, int S) {
        //Array of size N in which S no. of stacks implement
        stack = new int[S];
        //The indexes stored as an element in the top array denotes the top element position of all the N no of stacks in the array
        top = new int[N];
        //The next array performs 2 job
        // 1st is if the stack has no elements in the correspondence index then it stores the index of the next available space.
        //But if the element in the index is filled in the stack array then it stores the previous element index of that stack,
        //If there is no previous element then it stores -1
        next = new int[S];
        //Loop to initialize the top element with -1
        for (int i = 0; i < N; i++)
            top[i] = -1;
        // loop to initialize the next array with reference to the index of the next available space
        for (int i = 0; i < S - 1; i++)
            next[i] = i + 1;
        next[S - 1] = -1; // The last element in the next array is initialize as -1 because after this there was no space
        freeSpace = 0;// It denotes the next available space for push in the array.
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        //Check for stack overflow
        if (freeSpace == -1)
            return false;
        //Assign free space index for storing the push element
        int index = freeSpace; // Assign the free space index to the index var
        freeSpace = next[index]; // Update the free space to next available
        stack[index] = x; //Store the push element in the available space
        next[index] = top[m - 1]; // Update the current index of next which will point to the previous element index
        top[m - 1] = index; // Assign the index of the top element in the array
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        if (top[m - 1] == -1)
            return -1;
        int index = top[m - 1];
        top[m - 1] = next[index];
        next[index] = freeSpace;
        freeSpace = index;
        return stack[index];
    }
}
