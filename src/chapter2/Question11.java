package chapter2;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 旋转数组的最小数字
 * link:https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 * 思路： 二分查找
 */

public class Question11 {

    @Test
    public void test() {

        int[] test1 = {3, 4, 5, 1, 2};
        int[] test2 = {1, 0, 0, 0, 0, 1};
        // 3,4,5,1,2
        Assert.assertEquals(1, minNumberInRotateArray(test1));
        Assert.assertEquals(0, minNumberInRotateArray(test2));
    }

    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (array[start] >= array[end]) {
            int mid = (start + end) / 2;
            if (end - start == 1) {
                break;
            }

            if (array[start] == array[end] && array[start] == array[mid]) {
                return getMin(array);
            }

            if (array[mid] >= array[start]) {
                start = mid;
            } else if (array[mid] <= array[end]) {
                end = mid;
            }

        }

        return array[end];
    }

    private int getMin(int[] array) {
        if (array.length == 0) {
            return -1;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }


}
