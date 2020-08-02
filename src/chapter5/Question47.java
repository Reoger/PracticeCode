package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 礼物的最大价值
 *
 * @link {https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/}
 */

public class Question47 {

    @Test
    public void test() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        Assert.assertEquals(12, maxValue(grid));
        Assert.assertEquals(0, maxValue(new int[][]{{}}));
        Assert.assertEquals(12, maxValue2(grid));
        Assert.assertEquals(0, maxValue2(new int[][]{{}}));
    }


    public int maxValue(int[][] grid) {
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }

        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int maxValue2(int[][] grid) {

        int m = grid.length;
        if (m <= 0) {
            return 0;
        }

        int n = grid[0].length;
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0, up = 0;
                if (i > 0) {
                    left = dp[j];
                }

                if (j > 0) {
                    up = dp[j - 1];
                }

                dp[j] = Math.max(left, up) + grid[i][j];
            }
        }

        return dp[n - 1];
    }

}
