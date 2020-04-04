package chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 斐波那契数列
 * link: https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3
 * 思路： f(n) = f(n - 1) + f(n - 2)
 *
 * 数列： 1、1、2、3、5、8、13、21、34
 */

public class Question10 {

    @Test
    public void test() {

        Assert.assertEquals(Fibonacci2(3), Fibonacci(3));
        Assert.assertEquals(Fibonacci2(1), Fibonacci(1));
        Assert.assertEquals(Fibonacci2(5), Fibonacci(5));
        Assert.assertEquals(Fibonacci2(0), Fibonacci(0));
    }

    public int Fibonacci(int n) {
        if(n <= 1) {
            return n;
        }

        return Fibonacci(n -1) + Fibonacci(n -2);
    }

    //使用递推公式
    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        int result = 0;
        int pre2 = 0;
        int pre1 = 1;

        for (int i = 2; i <= n; i++) {
            result = pre1 + pre2;
            pre2 = pre1;
            pre1 = result;
        }

        return result;
    }

}
