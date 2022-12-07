package generics;

import java.util.Stack;



public class Assignment4 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        stack.push('J');
        stack.push('A');
        stack.push('V');
        stack.push('A');
        System.out.println(stack.toString());
        System.out.println(stack.peek());
        char ch = stack.pop();
        System.out.println(ch);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.toString());
        System.out.println(stack.search('V'));
        System.out.println(stack.search('J'));
        System.out.println(stack.empty());
        stack.pop();
        stack.pop();
        // stack.pop();
        // System.out.println(stack.peek());
        System.out.println(stack.empty());
        System.out.println();

        MyStack charStack = new MyStack();
        charStack.push('J');
        charStack.push('A');
        charStack.push('V');
        charStack.push('A');
        System.out.println(charStack.toString());
        System.out.println(charStack.peek());
        char ch2 = charStack.pop();
        System.out.println(ch2);
        System.out.println(charStack.peek());
        charStack.pop();
        System.out.println(charStack.toString());
        System.out.println(charStack.search('V'));
        System.out.println(charStack.search('J'));
        System.out.println(charStack.empty());
        charStack.pop();
        charStack.pop();
        // charStack.pop();
        // System.out.println(charStack.peek());
        System.out.println(charStack.empty());
        System.out.println();
    }
}


