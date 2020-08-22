package chapter6;

import org.junit.Assert;
import org.junit.Test;

/**
 * n 个骰子的点数
 *
 * @link {https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/}
 */
public class Question60 {

    @Test
    public void test() {
//        Assert.assertArrayEquals(new double[]{0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667},
//                twoSum(1), 0.00001);
//        Assert.assertArrayEquals(new double[]{0.02778, 0.05556, 0.08333, 0.11111, 0.13889, 0.16667,
//                0.13889, 0.11111, 0.08333, 0.05556, 0.02778}, twoSum(2), 0.00001);
        Assert.assertArrayEquals(new double[]{0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667},
                twoSum2(1), 0.00001);
        Assert.assertArrayEquals(new double[]{0.02778, 0.05556, 0.08333, 0.11111, 0.13889, 0.16667,
                0.13889, 0.11111, 0.08333, 0.05556, 0.02778}, twoSum2(2), 0.00001);
    }

    public double[] twoSum(int n) {
        int len = 5 * n + 1;
        int[] dp = new int[len];
        for (int i = 1; i <= 6 ; i++) {
           twoSumCore(n, n, i, dp);
        }
        double[] ratio = new double[len];
        double sum = Math.pow(6, n);
        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = dp[i] / sum;
        }

        return ratio;
    }

    // 递归思想，将 n 个骰子分成两部分，一部分只有一个，另一部分有 n-1 个，
    // 很容易计算只有一个的那一部分，然后剩下的那一部分 n-1 又可以分解成 1 和 n-2 两部分，
    // 上面很明显就是递归的思路,我们可以通过递归来解决该问题
    private void twoSumCore(int original, int current, int sum, int[] dp) {
        if (current == 1) {
            dp[sum - original] ++;
        } else {
            for (int i = 1; i <= 6; i++) {
                twoSumCore(original, current - 1, i + sum, dp);
            }
        }
    }


    public double[] twoSum2(int n) {
        int len = 5 * n + 1;
        int[][] dp = new int[n + 1][n * 6 + 1];
        //这里的 dp[i][j] 用来表示第 i 个骰子点数 j 出现的次数

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int k = i; k <= 6 * n; k++) {
                for (int j = 1; j <= 6; j++) {
                    if (k - j < 0) {
                        break;
                    }
                    dp[i][k] += dp[i - 1][k - j];
                }
            }
        }

        double[] ratio = new double[len];
        double sum = Math.pow(6, n);
        for (int i = 0; i < ratio.length; i++) {
            ratio[i] = dp[n][i + n] / sum;
        }
        return ratio;
    }
}
