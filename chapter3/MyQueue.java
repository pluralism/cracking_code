import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }


    public int size() {
        return stackNewest.size() + stackOldest.size();
    }


    public void add(T value) {
        stackNewest.add(value);
    }


    private void shiftStacks() {
        if(stackOldest.isEmpty())
            while(!stackNewest.isEmpty())
                stackOldest.push(stackNewest.pop());
    }


    public T peek() {
        shiftStacks();
        return stackOldest.peek(); // Get the oldest element
    }


    public T remove() {
        shiftStacks(); // Ensure that stackOldest has the current elements
        return stackOldest.pop();
    }
}
