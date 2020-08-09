package chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * 1. 数组中数字出现的次数,有两个数字只出现了1次，其余的出现了2次，求只出现1次的两个数字
 *
 * @link {https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/}
 * <p>
 * 1. 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 * @link {https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/}
 */

public class Question56 {

    @Test
    public void testForSingleNumbers() {
        Assert.assertArrayEquals(new int[]{1, 6}, singleNumbers(new int[]{4, 1, 4, 6}));
        Assert.assertArrayEquals(new int[]{2, 10}, singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3}));

        Assert.assertArrayEquals(new int[]{1, 6}, singleNumbers2(new int[]{4, 1, 4, 6}));
        Assert.assertArrayEquals(new int[]{10, 2}, singleNumbers2(new int[]{1, 2, 10, 4, 1, 4, 3, 3}));
    }

    public int[] singleNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.getOrDefault(num, 0);
            if (value == 1) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        int[] ans = new int[map.size()];
        int index = 0;
        for (Integer integer : map.keySet()) {
            ans[index++] = integer;
        }
        return ans;
    }

    public int[] singleNumbers2(int[] nums) {
        int[] ans = new int[2];
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        int index = getIndexOf1(temp);
        for (int num : nums) {
            if (isTarget(num, index)) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    private int getIndexOf1(int num) {
        int index = 0;
        while ((num & 1) != 1) {
            num = num >>> 1;
            index++;
        }
        return index;
    }

    private boolean isTarget(int num, int index) {
        return (num >>> index & 1) == 1;
    }


    @Test
    public void testSingleNumber() {
        Assert.assertEquals(1, signleNumber2(new int[]{1, 2, 2, 2, 3, 3, 3}));
    }


    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }

    public int signleNumber2(int[] nums) {
        int maxLength = 32;
        int result = 0;
        int[] counter = new int[maxLength];
        for (int num : nums) {
            for (int i = 0; i < maxLength; i++) {
                counter[i] += num & 1;
                num >>>= 1;
            }
        }
        for (int i = 0; i < maxLength; i++) {
            result <<= 1;
            result |= counter[maxLength - 1 - i] % 3;
        }
        return result;
    }

}
