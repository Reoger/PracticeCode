package chapter2;

import org.junit.Assert;
import org.junit.Test;

/**
 * 矩阵中的路径
 *
 * @see {https://www.nowcoder.com/practice/c61c6999eecb4b8f88a98f66b273a3cc}
 * 回溯法
 */

public class Question12 {

    @Test
    public void test() {

        char[] matrix = {
                'a', 'b', 'c', 'e',
                's', 'f', 'c', 's',
                'a', 'd', 'e', 'e'
        };

        char[] path1 = {'b', 'c', 'c', 'e', 'd'};
        char[] path2 = {'a', 'b', 'c', 'b'};

        Assert.assertTrue(hasPath(matrix, 3, 4, path1));
        Assert.assertFalse(hasPath(matrix, 3, 4, path2));
    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || matrix.length == 0 || rows <= 0 || cols <= 0) {
            return false;
        }

        boolean[][] visited = new boolean[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i * cols + j] == str[0]) {
                    visited[i][j] = true;
                    if (hadPathCore(matrix, rows, cols, i, j, 1, str, visited)) {
                        return true;
                    } else {
                        visited[i][j] = false;
                    }
                }
            }
        }
        return false;
    }

    // 该方法还可以通过将判断‍统一，减少重复的代码。核心思想不变。
    private boolean hadPathCore(char[] matrix, int rows, int cols, int curRow, int curCol, int index, char[] str,
                                boolean[][] visited) {
        if (str.length <= index) {
            return true;
        }

        // 上
        if (curRow - 1 >= 0 && matrix[(curRow - 1) * cols + curCol] == str[index] && !visited[curRow - 1][curCol]) {
            visited[curRow - 1][curCol] = true;
            if (hadPathCore(matrix, rows, cols, curRow - 1, curCol, index + 1, str, visited)) {
                return true;
            } else {
                visited[curRow - 1][curCol] = true;
            }
        }

        // 下
        if (curRow + 1 < rows && matrix[(curRow + 1) * cols + curCol] == str[index] && !visited[curRow + 1][curCol]) {
            visited[curRow + 1][curCol] = true;
            if (hadPathCore(matrix, rows, cols, curRow + 1, curCol, index + 1, str, visited)) {
                return true;
            } else {
                visited[curRow + 1][curCol] = false;
            }
        }

        //左
        if (curCol - 1 >= 0 && matrix[curRow * cols + curCol - 1] == str[index] && !visited[curRow][curCol - 1]) {
            visited[curRow][curCol - 1] = true;
            if (hadPathCore(matrix, rows, cols, curRow, curCol - 1, index + 1, str, visited)) {
                return true;
            } else {
                visited[curRow][curCol - 1] = false;
            }
        }

        //右
        if (curCol + 1 < cols && matrix[curRow * cols + curCol + 1] == str[index] && !visited[curRow][curCol + 1]) {
            visited[curRow][curCol + 1] = true;
            if (hadPathCore(matrix, rows, cols, curRow, curCol + 1, index + 1, str, visited)) {
                return true;
            } else {
                visited[curRow][curCol + 1] = false;
            }
        }

        return false;
    }

}
