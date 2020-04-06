package chapter4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 顺时针打印矩阵
 *
 * @link {https://leetcode-cn.com/problems/spiral-matrix/description}
 * {https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a}
 */


public class Question29 {

    @Test
    public void test() {
        int[][] matrix1 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int[][] matrix3 = {
                {1,2,3,4,5}
        };
        int[][] matrix4 = {
                {1},
                {2},
                {3},
                {4}
        };

        List test1 = spiralOrder(matrix1);
        List test2 = spiralOrder(matrix2);
        List test3 = spiralOrder(matrix3);
        List test4 = spiralOrder(matrix4);
        System.out.println(Arrays.toString(new List[]{test1}));
        System.out.println(Arrays.toString(new List[]{test2}));
        System.out.println(Arrays.toString(new List[]{test3}));
        System.out.println(Arrays.toString(new List[]{test4}));

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int col = matrix.length;
        int row = matrix[0].length;
        int x = 0, y = 0;
        int point = 0;
        while (point * 2  < row && point * 2 < col) {
            while (x < row - point) {
                result.add(matrix[y][x++]);
            }

            x = row - point - 1;
            y++;

            while (y < col - point) {
                result.add(matrix[y++][x]);
            }

            y = col - point - 1;
            x--;

            while (y > point && x >= point) {
                result.add(matrix[y][x--]);
            }

            x = point;
            y--;

            while (x != row - point - 1 &&  y > point) {
                result.add(matrix[y--][x]);
            }

            y = point + 1;
            x++;

            point++;

        }

        return result;
    }
}
