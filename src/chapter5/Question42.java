package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 连续子数组的最大和
 * link {https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484}
 */

public class Question42 {

    @Test
    public void test() {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        int a = FindGreatestSumOfSubArray(array);
        Assert.assertEquals(18, a);
    }


    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int max = array[0];
        int curValue = max;

        for (int i = 1; i < array.length; i++) {
            curValue += array[i];
            if (curValue < array[i]) {
                curValue = array[i];
            }
            if (curValue > max) {
                max = curValue;
            }
        }
        return max;
    }


}
