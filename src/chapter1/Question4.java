package chapter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题4：二维数组中的查找
 * ink：https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e
 * [1,2,3]
 * [2,3,4]
 * [3,4,5]
 */
public class Question4 {

    @Test
    public void test() {
        int array[][] = {
                {1,2,3},
                {2,3,4},
                {3,4,5}
        };
        Assert.assertEquals(true, Find(2, array));
        Assert.assertEquals(false, Find(0, array));
        Assert.assertEquals(false, Find(6, array));
    }


    public boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0|| array[0].length == 0) {
            return false;
        }

        int col = array.length;
        int row = array[0].length;
        int i = 0, j = col - 1;
        while (i < col && j < row && j >= 0 ) {
            if(array[i][j] == target) {
                return true;
            } else if(array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

}
