package chapter6;

import org.junit.Assert;
import org.junit.Test;

/**
 * 股票的最大利润
 * @Link {https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/}
 */
public class Question63 {

    @Test
    public void test() {
        Assert.assertEquals(5, maxProfit(new int[]{7,1,5,3,6,4}));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0];
        int res = 0;

        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }

        return res;
    }
}
