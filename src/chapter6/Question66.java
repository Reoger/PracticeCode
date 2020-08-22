package chapter6;

import org.junit.Assert;
import org.junit.Test;


/**
 * 构建乘积数组
 *
 * @Link {https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/}
 */

public class Question66 {

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{120, 60, 40, 30, 24}, constructArr(new int[]{1, 2, 3, 4, 5}));
    }

    public int[] constructArr(int[] a) {
        int[] dp = new int[a.length];
        dp[0] = 1;
        for (int i = 1; i < a.length; i++) {
            dp[i] = dp[i - 1] * a[i - 1];
        }

        int temp = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            dp[i] *= temp;
        }
        return dp;
    }


}
