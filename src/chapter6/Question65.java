package chapter6;

import org.junit.Assert;
import org.junit.Test;

/**
 * 不用加减乘除做加法
 * @LINK {https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/}
 */
public class Question65 {

    @Test
    public void test() {
        Assert.assertEquals(10, add(4,6));
    }

    public int add(int a, int b) {
        while (a != 0) {
            int c = (a & b) << 1;
            b ^= a;
            a = c;
        }
        return b;
    }

}
