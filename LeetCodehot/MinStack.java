package LeetCodehot;

import java.util.Stack;
/**
 * @program: code
 * @description:
 * @author: Mr.Mercury
 * @create: 2025-04-17 14:04
 **/
public class MinStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public MinStack() {
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(stack2.peek(),val));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
