package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 面试题51. 数组中的逆序对
 *
 * @link {https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/}
 */
public class Question51 {

    @Test
    public void test() {
        Assert.assertEquals(5, reversePairs(new int[]{7, 5, 6, 4}));
    }

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        return reverseCore(nums, copy, 0, nums.length - 1);
    }

    int reversePais(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;

        int left = reversePais(copy, data, start, start + length);
        int right = reversePais(copy, data, start + length + 1, end);

        // i 初始化为前半段最后一个数字的下标
        int i = start + length;
        // j 初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        for (; i >= start; --i) {
            copy[indexCopy--] = data[i];
        }
        for (; j >= start + length + 1; --j) {
            copy[indexCopy--] = data[j];
        }

        return left + right + count;
    }

    int reverseCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;

        int left = reverseCore(copy, data, start, start + length);
        int right = reverseCore(copy, data, start + length + 1, end);

        int count = 0;
        int i = start + length;
        int j = end;
        int index = j;

        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                count += j - start - length;
                copy[index--] = data[j--];
            } else {
                copy[index--] = data[i--];
            }
        }
        for (; i >= start; i--) {
            copy[index--] = data[i];
        }
        for (; j >= start + length + 1; j--) {
            copy[index--] = data[j];
        }
        return left + right + count;
    }

}
