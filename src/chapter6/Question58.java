package chapter6;

import org.junit.Assert;
import org.junit.Test;

/**
 * 1. 翻转单词顺序
 *
 * @link {https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/}
 *
 * 2.左旋转字符串
 * @link {https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/}
 */

public class Question58 {


    @Test
    public void testReverseWords() {
        Assert.assertEquals("blue is sky the", reverseWords("the sky is blue"));
        Assert.assertEquals("world! hello", reverseWords("  hello world!  "));
        Assert.assertEquals("example good a", reverseWords("a good   example"));

        Assert.assertEquals("blue is sky the", reverseWords2("the sky is blue"));
        Assert.assertEquals("world! hello", reverseWords2("  hello world!  "));
        Assert.assertEquals("example good a", reverseWords2("a good   example"));
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s.trim()).reverse();
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == ' ' && sb.charAt(i + 1) == ' ') {
                 sb.deleteCharAt(i--);
            }
        }

        int end = sb.length();
        int start = 0;
        for (int i = 0; i < end; i++) {
            if (sb.charAt(i) == ' ') {
                reverse(start, i - 1, sb);
                start = i + 1;
            }
        }
        reverse(start, end - 1, sb);
        return sb.toString();
    }

    private void reverse(int start, int end, StringBuilder sb) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public String reverseWords2(String s) {
        s = s.trim();
        int i = s.length() - 1;
        int j = i;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1);
            sb.append(" ");
            while (i > 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    @Test
    public void test() {
        Assert.assertEquals("cdefgab", reverseLeftWords("abcdefg", 2));
    }

    public String reverseLeftWords(String s, int n) {
        if (s == null) {
            return null;
        }
        int len = s.length();
        if (len == 0 || n > len) {
            return null;
        }
        StringBuilder sb = new StringBuilder(s);
        reverse(0, n - 1, sb);
        reverse(n, len - 1, sb);
        return sb.reverse().toString();
    }
}
