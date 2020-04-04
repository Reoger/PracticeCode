package chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 二进制中 1 的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @see {https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8}
 */
public class Question15 {

    @Test
    public void test() {
        Assert.assertEquals(1, NumberOf1(1));
        Assert.assertEquals(0, NumberOf1(0));
        Assert.assertEquals(2, NumberOf1(5));
    }

    public int NumberOf1(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);
            result++;
        }

        return result;
    }


    public int NumberOf2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result++;
            }
            n = n >> 1;
        }
        return result;
    }

}
