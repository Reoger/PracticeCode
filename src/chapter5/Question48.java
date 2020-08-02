package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 最长不含重复字符串的子字符串
 *
 * @link {https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/}
 */
public class Question48 {


    @Test
    public void test() {
        Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        int[] map = new int[128];
        for(int i = 0; i < map.length; i++) {
            map[i] = -1;
        }

        for (int i = 0; i < len; i++) {
            int index = s.charAt(i);
            int size = i - map[index];
            if(i == 0) {
                dp[i] = 1;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, size);
            }
            map[index] = i;
        }

        int maxValue = 0;
        for (int value : dp) {
            if (maxValue < value) {
                maxValue = value;
            }
        }

        return maxValue;
    }



}
