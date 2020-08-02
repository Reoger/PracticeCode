package chapter6;

import org.junit.Assert;
import org.junit.Test;

/**
 * 在排序数组中查找数字
 * 1.统计一个数字在排序数组中出现的次数
 *
 * @link {https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/}
 *
 * 2. 0～n-1中缺失的数字
 * @link {https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/}
 *
 */
public class Question53 {

    @Test
    public void testQuestion1() {
        Assert.assertEquals(3, search(new int[]{1, 2, 3, 3, 3, 4, 5}, 3));
        Assert.assertEquals(3, search(new int[]{1, 2, 3, 3, 3, 4, 5}, 3));
        Assert.assertEquals(0, search(new int[]{1, 2, 3, 3, 3, 4, 5}, 6));
        Assert.assertEquals(1, search2(new int[]{1, 2, 3, 3, 3, 4, 5}, 1));
        Assert.assertEquals(0, search2(new int[]{1, 2, 3, 3, 3, 4, 5}, 6));
        Assert.assertEquals(1, search2(new int[]{1, 2, 3, 3, 3, 4, 5}, 1));
    }


    @Test
    public void testQuestion2() {

//        Assert.assertEquals(1, missingNumber(new int[]{0,2,3,4,5,6}));
//        Assert.assertEquals(0, missingNumber(new int[]{1,2,3,4,5,6}));
//        Assert.assertEquals(6, missingNumber(new int[]{0,1,2,3,4,5,7}));
        Assert.assertEquals(1, missingNumber(new int[]{0}));
    }


    //通常思路：找到该数第一次出现的索引和最后一次出现的索引位置，相减 + 1 即为最后的解
    public int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }

        int start = getSmallerIndex(nums, target);
        int end = getBiggerIndex(nums, target);
        if (start == -1 || end == -1) {
            return 0;
        }
        return end - start + 1;
    }

    private int getSmallerIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
                return mid;
            } else if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int getBiggerIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target && (mid + 1 == nums.length || nums[mid + 1] > target)) {
                return mid;
            } else if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public int search2(int[] nums, int target) {
        return search2Core(nums, target) - search2Core(nums, target - 1);
    }

    private int search2Core(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }

    public int missingNumber(int[] nums) {
        int stat = 0;
        int end = nums.length - 1;
        while (stat <= end) {
            int mid = (stat + end) >>> 1;
            if (nums[mid] > mid && (mid == 0 || nums[mid - 1] == mid - 1)) {
                return mid;
            } else if (nums[mid] > mid) {
                end = mid - 1;
            } else {
                stat = mid + 1;
            }
        }
        return nums.length;
    }

}
