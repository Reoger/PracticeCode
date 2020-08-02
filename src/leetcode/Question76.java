package leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * @link {https://leetcode-cn.com/problems/minimum-window-substring/}
 * 类似的题目还有：leetcode 上的 3、209、424、438、567
 */


public class Question76 {


    @Test
    public void test() {
        Assert.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
        Assert.assertEquals("BANC", minWindow2("ADOBECODEBANC", "ABC"));

    }

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }
        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen) {
            return "";
        }

        int[] windowSlip = new int[128];
        int[] tSlip = new int[128];

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        for (char tChar : tChars) {
            tSlip[tChar]++;
        }

        int minLen = sLen + 1;
        int left = 0;
        int right = 0;
        int start = 0;
        int distance = 0;

        while (right < sLen) {
            char curChar = sChars[right];

            if (tSlip[curChar] == 0) {
                right++;
                continue;
            }

            if (windowSlip[curChar] < tSlip[curChar]) {
                distance++;
            }

            windowSlip[curChar]++;
            right++;

            while (distance == tLen) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char tempLeftChar = sChars[left];
                if (tSlip[tempLeftChar] == 0) {
                    left++;
                    continue;
                }

                if (windowSlip[tempLeftChar] == tSlip[tempLeftChar]) {
                    distance--;
                }

                windowSlip[tempLeftChar]--;
                left++;
            }
        }

        return minLen == sLen + 1 ? "" : s.substring(start, start + minLen);
    }


    public String minWindow2(String s, String t) {
        //ignore check null point

        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        int[] tFred = new int[128];
        for (char c : chart) {
            tFred[c]++;
        }

        int start = 0;
        int left = 0;
        int right = 0;
        int distance = chart.length;
        int minLen = chars.length + 1;

        while (right < chars.length) {
            char rightChar = chars[right];

            if (tFred[rightChar] > 0) {
                distance--;
            }
            tFred[rightChar]--;
            right++;

            while (distance == 0) {
                if (minLen > right - left) {
                    minLen = right - left;
                    start = left;
                }

                char leftChar = chars[left];
                if (tFred[leftChar] == 0) {
                    distance++;
                }
                tFred[leftChar]++;
                left++;
            }
        }

        return minLen == chars.length + 1 ? "" : s.substring(start, start + minLen);
    }

}
