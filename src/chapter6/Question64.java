package chapter6;

import org.junit.Assert;
import org.junit.Test;

/**
 * 求1+2+…+n
 *
 * @Link {https://leetcode-cn.com/problems/qiu-12n-lcof/}
 */

public class Question64 {


    @Test
    public void test() {
        Assert.assertEquals(6, sumNums(3));
        Assert.assertEquals(45, sumNums(9));
    }

    public int sumNums(int n) {
        boolean flay = (n > 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
