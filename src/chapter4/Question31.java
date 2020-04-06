package chapter4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @link {https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106}
 */
public class Question31 {

    @Test
    public void test() {
        int[] push1 = {1, 2, 3, 4, 5};
        int[] pop1 = {1, 2, 3, 4, 5};
        int[] pop2 = {4, 3, 5, 1, 2};

        Assert.assertTrue(IsPopOrder(push1, pop1));
        Assert.assertFalse(IsPopOrder(push1, pop2));
    }

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (popA == null || pushA == null) {
            return false;
        }
        if (pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int value : pushA) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
                if (j >= popA.length) {
                    break;
                }
            }
        }

        return stack.isEmpty();
    }


}
