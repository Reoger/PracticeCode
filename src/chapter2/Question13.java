package chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 机器人的运动范围
 *
 * @see { https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8 }
 * <p>
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子?
 * <p>
 * 回溯法
 */
public class Question13 {

    @Test
    public void test() {
        Assert.assertEquals(4, movingCount(2, 2, 2));
        Assert.assertEquals(0, movingCount(0, 0, 0));
    }


    public int movingCount(int threshold, int rows, int cols) {
        if (threshold <= 0 || rows == 0 || cols == 0) {
            return 0;
        }

        int[] count = new int[1];
        boolean[][] visited = new boolean[rows][cols];
        movingCountCore(threshold, rows, cols, 0, 0, count, visited);
        return count[0];
    }

    private boolean movingCountCore(int threshold, int rows, int cols, int i, int j,
                                    int[] count, boolean[][] visited) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return false;
        }
        if (getSumOfPoint(i) + getSumOfPoint(j) <= threshold && !visited[i][j]) {
            count[0]++;
            visited[i][j] = true;
        } else {
            return false;
        }

        return movingCountCore(threshold, rows, cols, i - 1, j, count, visited) ||
                movingCountCore(threshold, rows, cols, i + 1, j, count, visited) ||
                movingCountCore(threshold, rows, cols, i, j - 1, count, visited) ||
                movingCountCore(threshold, rows, cols, i, j + 1, count, visited);
    }


    private int getSumOfPoint(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        return result;
    }

}
