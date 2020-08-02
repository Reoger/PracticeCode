package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 除自身以外数组的乘积
 *
 * @link {https://leetcode-cn.com/problems/product-of-array-except-self/}
 */

public class Question238 {

    @Test
    public void test() {
//        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf(new int[]{1, 2, 3, 4}));
        Assert.assertArrayEquals(new int[]{24, 12, 8, 6}, productExceptSelf2(new int[]{1, 2, 3, 4}));
    }

    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) {
            return new int[]{};
        }

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] ans = new int[nums.length];

        left[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        right[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }

        return ans;
    }

    public int[] productExceptSelf2(int[] nums) {
        if(nums.length == 0) {
            return new int[]{};
        }

        int[] ans = new int[nums.length];
        ans[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }

        int rightProduct = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            rightProduct *= nums[i + 1];
            ans[i] *= rightProduct;
        }

        return ans;
    }

}
