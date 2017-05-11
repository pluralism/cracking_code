public class FixedMultiStack {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;


    public FixedMultiStack(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }


    // Push a new value onto the stack
    public void push(int stackNum, int value) {
        if(isFull(stackNum))
            System.err.println(String.format("Stack %d is full!", stackNum));

        sizes[stackNum]++;
        values[indexOfTop(stackNum)] = value;
    }


    // Pop item from the top of the stack
    public int pop(int stackNum) {
        if(isEmpty(stackNum))
            System.err.println(String.format("Stack %d is empty!", stackNum));

        int topIndex = indexOfTop(stackNum);
        // Save the value before clearing it
        int value = values[topIndex];
        values[topIndex] = 0;
        sizes[stackNum]--;

        return value;
    }


    // Return the top element of the stack
    public int peek(int stackNum) {
        if(isEmpty(stackNum))
            System.err.println(String.format("Stack %d is empty!", stackNum));

        return values[indexOfTop(stackNum)];
    }


    // Return if the stack is full
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }


    // Return if the stack if empty or not
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }


    // Returns the index of the top of the stack
    public int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }
}
