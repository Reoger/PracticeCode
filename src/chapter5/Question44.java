package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数字序列中的某一位的数字
 * link {https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/}
 */

public class Question44 {

    @Test
    public void test() {
        Assert.assertEquals(3, findNthDigit(3));
        Assert.assertEquals(1, findNthDigit(10));
        Assert.assertEquals(0, findNthDigit(11));
        Assert.assertEquals(1, findNthDigit(13));
        Assert.assertEquals(5, findNthDigit(100));
        Assert.assertEquals(7, findNthDigit(1001));
        Assert.assertEquals(1, findNthDigit(1000000000));
    }

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }

        int digit = 1;
        long index = 10;
        while (index <= n) {
            digit++;
            index += Math.pow(10, digit - 1) * digit * 9;
        }

        index -= Math.pow(10, digit - 1) * digit * 9;
        long diff = n - index;
        return getIndexOfNumber(diff, digit);
    }

    private int getIndexOfNumber(long diff, long digit) {
        int start = (int) Math.pow(10, digit - 1);
        long index = diff / digit;
        long indexOfRight = diff % digit;
        long tempNumber = start + index;

        for (int i = 1; i < digit - indexOfRight; i++) {
            tempNumber /= 10;
        }
        return (int) (tempNumber % 10);
    }

    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = 9 * digit * start;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }


}
