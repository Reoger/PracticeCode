package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class Question16 {

    @Test
    public void test() {
        Assert.assertEquals(2, threeSumClosest(new int[]{-1, 2, 1, -4, 1}, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (i != k && i != j && k != j) {
                        int sum = nums[i] + nums[j] + nums[k];
                        if (Math.abs(sum - target) <= Math.abs(ans - target)) {
                            ans = sum;
                        }
                    }
                }
            }
        }

        return ans;
    }

}
