package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中出现次数超过一半的数字
 *
 * @link {https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163}
 */
public class Question39 {

    @Test
    public void test() {
        int[] test1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] test2 = {4, 2, 1, 4, 2, 4};
        Assert.assertEquals(2, MoreThanHalfNum_Solution(test1));
    }


    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int curNumber = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == curNumber) {
                count++;
            } else {
                count--;
                if (count <= 0) {
                    curNumber = array[i];
                    count = 1;
                }
            }

        }
        if (checkDataIsVerfiy(array, curNumber)) {
            return curNumber;
        }
        return 0;
    }

    private boolean checkDataIsVerfiy(int[] array, int number) {
        int count = 0;
        for (int value : array) {
            if (value == number) {
                count++;
            }
        }
        return count * 2 >= array.length;
    }

}
