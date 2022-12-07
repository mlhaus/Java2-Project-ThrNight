package generics;

import java.util.*;

public class MyStack {
    private ArrayList<Character> stack;

    // Creates an empty Stack
    public MyStack() {
        stack = new ArrayList<>();
    }

    // Tests if this stack is empty.
    public boolean empty() {
        return stack.size() == 0;
    }

    // Looks at the object at the top of this stack without removing it from the stack.
    public char peek() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    // Removes the object at the top of this stack and returns that object as the value of this function.
    public char pop() {
        if (stack.size() == 0) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    // Pushes an item onto the top of this stack.
    public void push(char ch) {
        stack.add(ch);
    }

    // Returns the 1-based position where an object is on this stack.
    public int search(char ch) {
        int i = stack.lastIndexOf(ch);
        if (i >= 0) {
            return stack.size() - i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
