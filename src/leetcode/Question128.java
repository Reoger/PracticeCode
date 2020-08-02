package leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)
 *
 * @link {https://leetcode-cn.com/problems/longest-consecutive-sequence/}
 */
public class Question128 {

    @Test
    public void test() {
        Assert.assertEquals(4, longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        Assert.assertEquals(3, longestConsecutive(new int[]{1, 2, 0, 1}));
        Assert.assertEquals(3, longestConsecutive(new int[]{1, 0, -1}));
        Assert.assertEquals(4, longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2}));
        Assert.assertEquals(3, longestConsecutive2(new int[]{1, 2, 0, 1}));
        Assert.assertEquals(3, longestConsecutive2(new int[]{1, 0, -1}));
    }

    public int longestConsecutive(int[] nums) {
        int ans = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] tempNums = new int[set.size()];
        Iterator it = set.iterator();
        int index = 0;
        while (it.hasNext()) {
            tempNums[index++] = (int) it.next();
        }

        int curData = 1;
        for (int i = 1; i < tempNums.length; i++) {
            if (tempNums[i - 1] + 1 == tempNums[i]) {
                curData++;
            } else {
                curData = 1;
            }
            ans = Math.max(ans, curData);
        }

        return ans;
    }

    public int longestConsecutive2(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curLength = 1;
                while (set.contains(++num)) {
                    curLength++;
                    ans = Math.max(ans, curLength);
                }
            }
        }

        return ans;
    }
}
