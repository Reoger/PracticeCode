package chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * 和为s的两个数字
 *
 * @link {https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/}
 *
 * 和为s的连续正数序列
 * @link {https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/}
 */
public class Question57 {

    @Test
    public void testTwoSum() {
        Assert.assertArrayEquals(new int[]{2, 7}, twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                ans[0] = nums[start];
                ans[1] = nums[end];
                break;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return ans;
    }


    @Test
    public void testFind() {
        int[][] ans = {
                {1, 2, 3},
                {4, 5}
        };
        int[][] res = findContinuousSequence(9);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + ", ");
            }
            System.out.println();
        }
    }

    public int[][] findContinuousSequence(int target) {
        int start = 0;
        int end = start + 1;
        int maxValue = target / 2 + 1;
        int sum = start + end;
        ArrayList<int[]> ans = new ArrayList<>();
        while (start < end && end <= maxValue) {
            if (sum == target) {
                ans.add(buildSequence(start, end));
                sum += ++end;
            } else if (sum < target) {
                sum += ++end;
            } else {
                sum -= start++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    private int[] buildSequence(int start, int end) {
        int[] res = new int[end - start + 1];
        int index = 0;
        for (int i = start; i <= end; i++) {
            res[index++] = i;
        }
        return res;
    }
}
