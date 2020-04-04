package chapter1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * link:https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
 * 思路：push 时，将元素都 push 到 stack1
 * pop 时，在将元素从 stack2 中 pop 出来，如果 stack2 中还没有元素，则先将 stack1 中的元素赋值到 stack2 中
 */

public class Question9 {

    @Test
    public void test() {
        push(1);
        push(2);
        push(3);
        push(4);
        Assert.assertEquals(1,pop());
        Assert.assertEquals(2,pop());
        Assert.assertEquals(3,pop());
        Assert.assertEquals(4,pop());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        return -1;
    }

}
