package chapter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * 数组中重复的数字
 * 题目1：找出数组中重复的数字
 * link：https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8
 *
 */

public class Question3 {

    @Test
    public void test() {
        int[] numes = {1,2,2,3,4,6};
        int[] result = new int[1];
        duplicate(numes, numes.length, result);
        Assert.assertEquals(2, result[0]);

    }

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if(numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        int[] map = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if(map[numbers[i]] != 0) {
                duplication[0] = numbers[i];
                return true;
            }
            map[numbers[i]]++;
        }
        return false;
    }


}
