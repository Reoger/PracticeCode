package leetcode;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 地下城游戏
 *
 * @link {https://leetcode-cn.com/problems/dungeon-game/}
 */
public class Question174 {

    @Test
    public void test() {

        Assert.assertEquals(7, calculateMinimumHP(new int[][]{{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}}));
    }


    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        if (row <= 0) {
            return 0;
        }
        int col = dungeon[0].length;
        if (col <= 0) {
            return 0;
        }
        int[][] dp = new int[row + 1][col + 1];

        for (int i = 0; i <= row; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[row][col - 1] = dp[row - 1][col] = 1;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }
}
