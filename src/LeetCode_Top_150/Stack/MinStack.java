package LeetCode_Top_150.Stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {

    }

    Stack<Integer> stack = null;
    Stack<Integer> minStack = null;
    int min;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        if( minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
        stack.push(val);

    }

    public void pop() {


        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
