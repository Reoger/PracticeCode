package chapter4;

import java.util.Stack;

/**
 * 包含 min 函数的栈
 *
 * @link {https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49}
 */

public class Question30 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            int min = minStack.peek();
            if (node < min) {
                minStack.push(node);
            } else {
                minStack.push(min);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
