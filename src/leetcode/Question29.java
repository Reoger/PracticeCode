package leetcode;

import org.junit.Assert;
import org.junit.Test;



/**
 * 顺时针打印矩阵
 *
 * @link {https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/}
 */
public class Question29 {

    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        Assert.assertArrayEquals(new int[]{1, 2, 3, 6, 9, 8, 7, 4, 5},
                spiralOrder(matrix));
        Assert.assertArrayEquals(new int[]{6, 9, 7}, spiralOrder(new int[][]{{6, 9, 7}}));
        Assert.assertArrayEquals(new int[]{6, 9, 7}, spiralOrder(new int[][]{{6},{9},{7}}));


    }

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[] ans = new int[row * col];
        int point = 0;
        int index = 0;
        int i, j;
        while (point * 2 < col && point * 2 < row) {
            i = point;
            j = point;
            while (j < col - point) {
                ans[index++] = matrix[i][j++];
            }
            j--;
            while (++i < row - point) {
                ans[index++] = matrix[i][j];
            }
            i--;
            while (i > point && --j >= point) {
                ans[index++] = matrix[i][j];
            }
            j++;
            while (j != col - point - 1 && --i > point) {
                ans[index++] = matrix[i][j];
            }
            point++;
        }

        return ans;
    }


}
