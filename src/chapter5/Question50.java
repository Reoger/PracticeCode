package chapter5;

import org.junit.Assert;
import org.junit.Test;

/**
 * 第一个只出现一次的字符
 *
 * @link {https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/}
 */

public class Question50 {

    @Test
    public void test() {
        Assert.assertEquals('b', firstUniqChar("abaccdeff"));
    }

    public char firstUniqChar(String s) {
        if (null == s || s.length() == 0) {
            return ' ';
        }

        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        for (char c : s.toCharArray()) {
            if (map[c] == 1) {
                return c;
            }
        }

        return ' ';
    }
}
