package chapter5;

import org.junit.Assert;
import org.junit.Test;


/**
 * 丑数
 *
 * @link {https://leetcode-cn.com/problems/chou-shu-lcof/}
 */

public class Question49 {

    @Test
    public void test() {
        Assert.assertEquals(12, nthUglyNumber(10));
    }

    public int nthUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }

        int[] dp = new int[index + 2];
        dp[0] = 1;

        int indexOf2 = 0;
        int indexOf3 = 0;
        int indexOf5 = 0;

        int multiOf2 = 2;
        int multiOf3 = 3;
        int multiOf5 = 5;

        for (int i = 1; i < index; i++) {
            dp[i] = Math.min(Math.min(dp[indexOf2] * multiOf2, dp[indexOf3] * multiOf3), dp[indexOf5] * multiOf5);

            while (dp[indexOf2] * multiOf2 <= dp[i])
                indexOf2++;
            while (dp[indexOf3] * multiOf3 <= dp[i])
                indexOf3++;
            while (dp[indexOf5] * multiOf5 <= dp[i])
                indexOf5++;
        }

        return dp[index - 1];
    }
}
