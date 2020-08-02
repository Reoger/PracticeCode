package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 新 21 点
 *
 * @LinK {https://leetcode-cn.com/problems/new-21-game/}
 */
public class Question837 {

    @Test
    public void test() {
        Assert.assertEquals(1.00000, new21Game(10, 1, 10), 0.00001);
        Assert.assertEquals(0.60000, new21Game(6, 1, 10), 0.00001);
        Assert.assertEquals(0.73278, new21Game(21, 17, 10), 0.00001);
        Assert.assertEquals(0.018467, new21Game(9301, 9224, 7771), 0.00001);
    }

    public double new21Game(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        int len = Math.min(N + 1, K + W);
        for (int i = K; i < len; i++) {
            dp[i] = 1.0;
        }

        double sum = 0;
        for (int i = K - 1; i < K + W; i++) {
            sum += dp[i];
        }
        sum = sum / W;
        dp[K - 1] = sum;


        for (int i = K - 2; i >= 0; i--) {
            sum += (dp[i + 1] - dp[i + W + 1]) / W;
            dp[i] = sum;
        }

        return dp[0];

    }

}
