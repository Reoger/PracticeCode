package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * link {https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/}
 */
public class Question309 {

    @Test
    public void test() {
//        Assert.assertEquals(maxProfit(new int[]{1, 2, 3, 0, 2}), 3);
        Assert.assertEquals(maxProfit2(new int[]{1, 2, 3, 0, 2}), 3);
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1];
            int j = i - 1;
            while (j >= 0 && prices[j] < prices[i]) {
                int temp = j - 2 >= 0 ? dp[j - 2] : 0;
                dp[i] = Math.max(dp[i], prices[i] - prices[j] + temp);
                j--;
            }
        }
        return dp[len - 1];
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }

        int[][] dp = new int[len][3];
        dp[0][0] = -prices[0];
        // dp[i][0] 代表第 i 天持有股票的最大收益
        // dp[i][1] 代表第 i 天，不持有股票，处于冷却期的最大收益
        // dp[i][2] 代表第 i 天，不持有股票，不处于冷却期的最大收益
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }

        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }































}
