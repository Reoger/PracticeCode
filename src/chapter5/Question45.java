package chapter5;

import org.junit.Assert;
import org.junit.Test;


/**
 * 把数字排列成最小的数
 * link {https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/}
 */

public class Question45 {

    @Test
    public void test() {
        int[] test1 = {10, 2};
        int[] test2 = {3, 30, 34, 5, 9};
        Assert.assertEquals("102", minNumber(test1));
        Assert.assertEquals("3033459", minNumber(test2));
    }

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        sort(nums, 0, nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }

    private void sort(int[] num, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int temp = i;

        while (i < j) {
            while (i < j && compareAtoB(num[j], num[temp]))
                j--;
            while (i < j && compareAtoB(num[temp], num[i]))
                i++;
            swap(num, i, j);
        }
        swap(num, i, temp);

        sort(num, start, i - 1);
        sort(num, i + 1, end);
    }

    private boolean compareAtoB(int i, int j) {
        String a = i + String.valueOf(j);
        String b = j + String.valueOf(i);
        int len = a.length();
        for (int k = 0; k < len; k++) {
            if (a.charAt(k) > b.charAt(k)) {
                return true;
            } else if (a.charAt(k) < b.charAt(k)) {
                return false;
            }
        }
        return true;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
