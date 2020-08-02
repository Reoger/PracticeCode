package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 寻找两个正序数组的中位数
 * <p>
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * link：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class Question4 {

    @Test
    public void test() {
        Assert.assertEquals(2.0, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0001);
        Assert.assertEquals(2.5, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0001);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int n = nums1.length;
        int m = nums2.length;
        int total = (m + n + 1) / 2;
        int left = 0;
        int right = n;

        // nums1[i] < nums2[j + 1] && nums2[j] < nums1[i + 1]
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = total - i;
            if (nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else {
                left = i;
            }
        }

        int indexOf1 = left;
        int indexOf2 = total - left;

        int num1Left = indexOf1 == 0 ? Integer.MIN_VALUE : nums1[indexOf1 - 1];
        int num1Right = indexOf1 == n ? Integer.MAX_VALUE : nums1[indexOf1];
        int num2Left = indexOf2 == 0 ? Integer.MIN_VALUE : nums2[indexOf2 - 1];
        int num2Right = indexOf2 == m ? Integer.MAX_VALUE : nums2[indexOf2];

        if (((m + n) & 1) == 1) {
            return Math.max(num1Left, num2Left);
        } else {
            return (Math.max(num1Left, num2Left) + Math.min(num2Right, num1Right)) / 2.0;
        }
    }


}
