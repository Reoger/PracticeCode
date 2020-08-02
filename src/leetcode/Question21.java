package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Question21 {

    @Test
    public void test() {
        Assert.assertEquals(1, firstMissingPositive(new int[]{-5}));
    }

    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();
        int maxValue = 0;
        for(int num: nums) {
            set.add(num);
            maxValue = Math.max(maxValue, num);
        }

        for(int i = 1; i < maxValue; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }

        return maxValue + 1;
    }

}
