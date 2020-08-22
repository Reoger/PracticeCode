package chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 *
 * @Link {https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/}
 */
public class Question61 {


    @Test
    public void test() {
        Assert.assertTrue(isStraight(new int[]{1, 2, 4, 5, 3}));
        Assert.assertTrue(isStraight(new int[]{0, 2, 4, 5, 3}));
        Assert.assertTrue(isStraight(new int[]{1, 2, 0, 5, 3}));
        Assert.assertFalse(isStraight(new int[]{1, 2, 1, 5, 3}));
    }

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int jokerSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                break;
            }
            jokerSize++;
        }

        int sum = 0;
        for (int i = jokerSize; i < nums.length - 1; i++) {
            int diff = nums[i + 1] - nums[i];
            if (diff == 0) {
                return false;
            }
            sum += diff - 1;
        }

        return sum - jokerSize <= 0;
    }

}
