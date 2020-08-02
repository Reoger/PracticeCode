package leetcode;


import org.junit.Assert;
import org.junit.Test;

/**
 * 正则表达式匹配
 *
 * @link {https://leetcode-cn.com/submissions/detail/80373185/}
 */
public class Question10 {

    @Test
    public void test() {
        Assert.assertFalse(isMatch("mississippi", "mis*is*p*."));
        Assert.assertTrue(isMatch("aa", "a*"));
        Assert.assertFalse(isMatch("aa", "a"));
        Assert.assertTrue(isMatch("a", "ab*"));
        Assert.assertFalse(isMatch("ab", ".*c"));
        Assert.assertTrue(isMatch("ab", ".*"));
    }

    public boolean isMatch(String s, String p) {
        if (p == null && s == null) {
            return true;
        }
        if (p == null) {
            return false;
        }

        return isMatchCore(s.toCharArray(), 0, p.toCharArray(), 0);
    }


    private boolean isMatchCore(char[] s, int indexS, char[] p, int indexP) {
        if (indexS >= s.length && indexP >= p.length) {
            return true;
        }
        if (indexP >= p.length) {
            return false;
        }


        if (indexP + 1 < p.length && p[indexP + 1] == '*') {
            if (indexS < s.length && (s[indexS] == p[indexP] || p[indexP] == '.')) {
                return isMatchCore(s, indexS + 1, p, indexP) ||
                        isMatchCore(s, indexS, p, indexP + 2) ||
                        isMatchCore(s, indexS + 1, p, indexP + 2);
            } else {
                return isMatchCore(s, indexS, p, indexP + 2);
            }
        }

        if (indexS >= s.length) {
            return false;
        }

        if (s[indexS] == p[indexP] || p[indexP] == '.') {
            return isMatchCore(s, indexS + 1, p, indexP + 1);
        }

        return false;

    }

}
