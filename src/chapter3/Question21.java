package chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * @see {https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593}
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

public class Question21 {

    @Test
    public void test() {
        int[] num1 = {1,2,3,4,5,6,7};
        reOrderArray(num1);
        System.out.println(Arrays.toString(num1));
    }

    public void reOrderArray(int[] array) {
        if (array == null) {
            return;
        }

        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenList.add(array[i]);
            } else {
                oddList.add(array[i]);
            }
        }
        int index;
        int len = oddList.size();
        for (index = 0; index < len; index++) {
            array[index] = oddList.get(index);
        }
        for (int i = 0; index < array.length; index++, i++) {
            array[index] = evenList.get(i);
        }
    }




}
